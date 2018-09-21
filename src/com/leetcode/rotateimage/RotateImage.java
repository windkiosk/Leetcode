package com.leetcode.rotateimage;

/**
 * Created by titan-developer on 11/3/14.
 * https://oj.leetcode.com/problems/rotate-image/
 */
public class RotateImage {

    public static void main(String[] strings) {
        int[][] a = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25},
        };

//        int[][] a = {
//                {1, 2, 3,},
//                {4, 5, 6,},
//                {7, 8, 9,},
//        };

        RotateImage rotate = new RotateImage();
        rotate.rotate(a);

        for (int[] b : a) {
            for (int v : b) {
                System.out.print(v + ",");
            }
            System.out.println();
        }
    }

    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length < 2) {
            return;
        }

        int l = matrix.length;
        int tmp;
        for (int i = 0; i < l / 2 ; i++) {
            for (int j = i; j < l - i - 1; j++) {
                tmp = matrix[i][j];
                matrix[i][j] = matrix[l - 1 - j][i];
                matrix[l - 1 - j][i] = matrix[l - 1 - i][l - 1 - j];
                matrix[l - 1 - i][l - 1 - j] = matrix[j][l - 1 - i];
                matrix[j][l - 1 - i] = tmp;
            }
        }
    }
}
