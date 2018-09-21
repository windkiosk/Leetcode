package com.practise1;

public class AVLTreeTest {

    private static int arr[] =
//        {10,40,20,30};
//        {10,20,30,40,50,60,70};
            {3, 2, 1, 4, 5, 6, 7, 16, 15, 14, 13, 12, 11, 10, 8, 9};


    public static void main(String[] args) {
        int i;
        AVLTree<Integer> tree = new AVLTree<Integer>();

        for (i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
            tree.add(arr[i]);
        }


        tree.levelOrder1();

//        tree.levelOrder2();
//
//        tree.levelOrder3();
    }

}