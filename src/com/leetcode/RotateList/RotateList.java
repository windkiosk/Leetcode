package com.leetcode.rotateList;

import com.leetcode.util.ListNode;

/**
 * Created by titan-developer on 10/31/14.
 * https://oj.leetcode.com/problems/rotate-list/
 */
public class RotateList {

    public static void main(String[] strings) {

        ListNode ori = ListNode.createList("1->2->3->4->5");
        RotateList rotateList = new RotateList();
        ListNode rotatee = rotateList.rotateRight(ori, 5);
        ListNode.print(rotatee);

        int i;
        for (i = 1; i < 11; i++) {
            System.out.println("Count is: " + i);
        }
        System.out.println("Last Count is: " + i);
    }

    /**
     * Since n may be a large number compared to the length of list. So we need to know the length of linked list.After that, move the list after the (l-n%l )th node to the front to finish the rotation.
     * <p/>
     * Ex: {1,2,3} k=2 Move the list after the 1st node to the front
     * <p/>
     * Ex: {1,2,3} k=5, In this case Move the list after (3-5%3=1)st node to the front.
     * <p/>
     * So the code has three parts.
     * <p/>
     * 1) Get the length
     * <p/>
     * 2) Move to the (l-n%l)th node
     * <p/>
     * 3)Do the rotation
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode rotateRight(ListNode head, int n) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy, slow = dummy;

        int i;
        for (i = 0; fast.next != null; i++)//Get the total length
            fast = fast.next;

        if (n % i == 0) return dummy.next;
        for (int j = i - n % i; j > 0; j--) //Get the i-n%i th node
            slow = slow.next;

        fast.next = dummy.next; //Do the rotation
        dummy.next = slow.next;
        slow.next = null;

        return dummy.next;
    }
}
