package com.interviewproblems.findtriagle;

/**
 * Created by titan-developer on 9/16/14.
 */
public class FindTriangle {

//    static int[] V = {1, 2, 3, 4, 5, 6};
//    static int[][] E = {{1, 2}, {1, 5}, {2, 3}, {2, 5}, {3, 4}, {4, 5}, {4, 6}};

    public static void main(String[] strings) {
        int[][] matrix = new int[6][6];

        matrix[0][1] = 1;
        matrix[0][4] = 1;
        matrix[1][4] = 1;
        matrix[1][2] = 1;
        matrix[2][3] = 1;
        matrix[2][5] = 1;
        matrix[3][4] = 1;
        matrix[3][5] = 1;

        FindTriangle findTriangle = new FindTriangle();
        System.out.println(findTriangle.findTriangle(matrix, 6));
    }

    public int findTriangle(int[][] matrix, int v) {
        int count = 0;

        if (matrix == null || matrix.length == 0 || v <= 0) {
            return count;
        }

        for (int i = 0; i < v; i++) {
            for (int m = i + 1; m < v; m++) {
                if (matrix[i][m] == 1) {
                    int tempV = m + 1;
                    while (tempV < v) {
                        if (tempV > m) {
                            if (matrix[i][tempV] == 1 && matrix[m][tempV] == 1)
                                count++;
                        } else {
                            if (matrix[i][tempV] == 1 && matrix[tempV][m] == 1)
                                count++;
                        }

                        tempV++;
                    }
                }
            }
        }

        return count;
    }

}
