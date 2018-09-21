package com.leetcode.combinationsum3;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bod on 11/19/2014.
 */
public class CombinationSum3 {

    public static void main(String[] strings) {

        int a[] = {2, 3, 7};

        CombinationSum3 sum = new CombinationSum3();

        //need care about the order.
        List<List<Integer>> solutions = sum.sumToTarget(a, 7);

        for (List solution : solutions) {
            for (int x = 0; x < solution.size(); x ++) {
                System.out.print(solution.get(x) + ", ");
            }
            System.out.println();
        }
    }

    void sumToTargetDFS(int[] arr, int target, int sum, List<Integer> output,  List<List<Integer>> result) {
        if (sum > target) {
            return;
        } else if (sum == target) {
            ArrayList newOut = new ArrayList(output);
            result.add(newOut);
        } else {
            for (int i = 0; i < arr.length; i++) {
                sum += arr[i];
                output.add(arr[i]);
                sumToTargetDFS(arr, target, sum, output, result);
                sum -= arr[i];
                output.remove(output.size() - 1);
            }
        }
    }

    List<List<Integer>> sumToTarget(int[] arr, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (0 == arr.length || target == 0) {
            return result;
        }

        ArrayList<Integer> output = new ArrayList<Integer>();
        int sum = 0;
        sumToTargetDFS(arr, target, sum, output, result);
        return result;
    }
}
