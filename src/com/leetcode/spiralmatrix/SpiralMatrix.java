package com.leetcode.spiralmatrix;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by titan-developer on 11/3/14.
 * https://oj.leetcode.com/problems/spiral-matrix/
 */
public class SpiralMatrix {

    public static void main(String[] strings) {
        int[][] a = {
                {1, 2, 3, 11},
                {4, 5, 6, 12},
                {7, 8, 9, 10}
        };

        SpiralMatrix spiralMatrix = new SpiralMatrix();
        List<Integer> list = spiralMatrix.spiralOrder(a);

        for (int v : list) {
            System.out.print(v + ", ");
        }
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ret = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return ret;
        int x = 0, y = 0, direction = 0, left = 0, top = 0, right = matrix[0].length - 1, bottom = matrix.length - 1;
        ret.add(matrix[y][x]);
        while(ret.size() < matrix.length * matrix[0].length) {
            boolean isMove = false;
            while(!isMove) {
                switch(direction) {
                    case 0: {
                        if (x < right) {
                            isMove = true;
                            x ++;
                        } else {
                            top ++;
                            direction = 1;
                        }
                        break;
                    }
                    case 1: {
                        if (y < bottom) {
                            isMove = true;
                            y ++;
                        } else{
                            right --;
                            direction = 2;
                        }
                        break;
                    }
                    case 2: {
                        if (x > left) {
                            isMove = true;
                            x --;
                        } else {
                            bottom --;
                            direction = 3;
                        }
                        break;
                    }
                    case 3: {
                        if (y > top) {
                            isMove = true;
                            y --;
                        } else {
                            left ++;
                            direction = 0;
                        }
                        break;
                    }
                }
                if (isMove) ret.add(matrix[y][x]);
            }
        }
        return ret;
    }
}
