package com.leetcode.FindKthSmallest;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by titan-developer on 12/3/14.
 */
public class FindKthSmallest {

    public static void main(String[] args) {
        int[] a = {23, 45, 1, 34, 89, 8, 22, 21, 4, 68};

        FindKthSmallest findKthSmallest = new FindKthSmallest();

        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");

        System.out.println();

        System.out.println(findKthSmallest.find(a, 7) + " - 7th smallest");

        System.out.println(findKthSmallest.findKthSmallestByHeap(a, 7) + " - 7th smallest by heap");

        System.out.println(findKthSmallest.find2ndSmallest(a) + " - 2th smallest");
    }

    public int find2ndSmallest(int[] nums) {
        if (nums.length < 2)
            return 0;

        int smallest = nums[0];
        int second = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= smallest) {
                second = smallest;
                smallest = nums[i];
            } else if (nums[i] < second) {
                second = nums[i];
            }
        }

        return second;
    }

    public int find(int[] a, int k) {
        return findKSmallest(a, 0, a.length - 1, k);
    }

    private int findKSmallest(int[] a, int p, int r, int k) {
        if (p == r)
            return a[r];
        int q = partition(a, p, r);
        int leftlen = q - p + 1;
        if (k == leftlen)
            return a[q];
        else if (k < leftlen)
            return findKSmallest(a, p, q - 1, k);
        else
            return findKSmallest(a, q + 1, r, k - leftlen);
    }

    private int partition(int[] A, int p, int r) {
        int prefix = p - 1;
        int pivot = A[r];
        for (int j = p; j < r; j++) {
            if (A[j] <= pivot) {
                prefix++;
                /** exchange A[prefix] and A[j] **/
                int temp = A[prefix];
                A[prefix] = A[j];
                A[j] = temp;
            }
        }
        int temp = A[prefix + 1];
        A[prefix + 1] = A[r];
        A[r] = temp;

        return prefix + 1;
    }

    public int findKthSmallestByHeap(int[] nums, int k) {
        if (nums.length == 0 || k > nums.length)
            return -1;

        int n = nums.length;
        int ksmallest = 0;

        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(k,
                new myComp());

        for (int i = 0; i < n; i++) {
            heap.add(nums[i]);
        }
        int count = 0;
        while (!heap.isEmpty() && count <= n - k) {
            ksmallest = heap.poll();
            count++;
        }
        return ksmallest;
    }

}

class myComp implements Comparator<Integer> {
    public int compare(Integer i1, Integer i2) {
        return i2 - i1;
    }
}
