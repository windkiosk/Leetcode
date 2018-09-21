package com.java.language.util.doublelindedlist;

/**
 * Created by titan-developer on 12/1/14.
 */

public class TestDllist {

    /**
     * @param args
     */
    public static void main(String[] args) {

        Integer[] integers = new Integer[10];
        for (int i = 0; i < 10; i++)
            integers[0] = new Integer(i + 1);

        DlList dl = new DlList(integers);

        print(dl);

    }

    public static void print(DlList dl) {
        System.out.println("双向循环链表遍历结果:");
        Dlnode p;
        p = dl.dlhead.next;
        while (p != dl.dlhead) {
            System.out.print(p.getData() + " ");
            p = p.next;
        }
    }

}