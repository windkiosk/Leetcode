package com.leetcode.missingranges;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by titan-developer on 12/25/14.
 * https://oj.leetcode.com/problems/missing-ranges/
 */
public class MissingRanges {
    public List<String> findMissingRanges(int[] A, int lower, int upper) {
        int curr = lower;
        List<String> ret = new ArrayList<String>();

        for (int i = 0; i < A.length; i ++) {
            if (A[i] != curr)
                addToResult(ret, curr, (A[i] - 1) > upper ? upper : (A[i] - 1));

            curr = A[i] + 1;

            if (curr > upper) break;
        }

        if (curr <= upper) addToResult(ret, curr, upper);

        return ret;
    }

    void addToResult(List<String> ret, int start, int end) {
        if (start == end)
            ret.add("" + start);
        else
            ret.add(start + "->" + end);
    }
}
