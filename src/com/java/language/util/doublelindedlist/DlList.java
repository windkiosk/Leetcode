package com.java.language.util.doublelindedlist;

/**
 * Created by titan-developer on 12/1/14.
 */
public class DlList {

    Dlnode dlhead;// 链表表头
    int size;

    public DlList() {
        dlhead = new Dlnode();
        dlhead.prior = dlhead;
        dlhead.next = dlhead;
        size = 0;
    }// 构造一个空表

    public DlList(Object[] a) {// 用数组a构造一个双向循环链表
        dlhead = new Dlnode();
        dlhead.prior = dlhead;
        dlhead.next = dlhead;
        Dlnode p = null;
        for (int i = a.length - 1; i >= 0; i--) {
            p = new Dlnode(dlhead, a[i], dlhead.next);
            dlhead.next.setPrior(p);
            dlhead.setNext(p);

        }

        size = a.length;

    }

    public void clear() {
        dlhead = new Dlnode();
        dlhead.prior = dlhead;
        dlhead.next = dlhead;
    }

    /**
     * 找到双向循环链表中第i个节点 首节点是第0个节点，然后 是第1个节点，依次类推
     *
     * @param i
     * @return
     */
    public Dlnode index(int i) {
        Dlnode p;
        int j;
        if (i < 0 || i > size)
            p = null;
        else if (i == 0)
            p = dlhead;
        else {
            p = dlhead.next;
            j = 1;
            while (j < i && p != null) {
                p = p.next;
                j++;

            }

        }

        return p;

    }

    /**
     * 得到第i个节点的data值
     *
     * @param i
     * @return
     */
    public Object get(int i) {
        Dlnode p;
        if (i <= 0 || i > size)
            return null;
        else {
            p = index(i);
            return p.getData();

        }

    }

    /**
     * 计算双向循环链表的长度
     */

    public int len() {
        return size;
    }

    /**
     * 得到data域为el的节点索引号
     *
     * @param el
     * @return
     */
    public int loc(Object el) {
        Dlnode p;
        int j = 1;
        p = dlhead.next;
        while (!p.data.equals(el) && p != dlhead) {// 双向循环链表结束的条件是尾结点的下一个指针是否指向头结点
            j++;
            p = p.next;

        }

        if (p != dlhead)
            return j;
        else
            return 0;

    }

    /**
     * 第一个参数是插入的位置 第二个参数是插入节点的data值
     *
     * @param loc
     * @param el
     * @return
     */
    public boolean insert(int loc, Object el) {
        if (loc < 1 && loc > size + 1)
            return false;
        Dlnode p = index(loc - 1);
        Dlnode q = new Dlnode(p, el, p.next);
        p.next.setPrior(q);
        p.setNext(q);
        size++;

        return true;

    }

    /**
     * 删除结点，提供删除节点的索引号
     */

    public Object delete(int i) {
        if (size == 0 || i < 1 || i > size)
            return null;
        Dlnode p = index(i);
        Object data = p.getData();
        p.prior.setNext(p.next);
        p.next.setPrior(p.prior);
        size--;
        return data;

    }

    public boolean empty() {
        return dlhead.next == dlhead;
    }

}
