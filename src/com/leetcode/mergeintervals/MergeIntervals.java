package com.leetcode.mergeintervals;

import java.util.*;

/**
 * Created by titan-developer on 10/31/14.
 * https://oj.leetcode.com/problems/merge-intervals/
 */
public class MergeIntervals {

    public static void main(String[] strings) {
        int[][] pairs = {{2, 6}, {1, 3}, {15, 18}, {8, 10}};

        List<Interval> list = new ArrayList<Interval>();

        for (int[] pair : pairs) {
            list.add(new Interval(pair[0], pair[1]));
        }

        MergeIntervals merger = new MergeIntervals();
        List<Interval> result = merger.merge(list);

        for (Interval interval : result) {
            System.out.println(interval.start + " , " + interval.end);
        }
    }

    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() <= 1)
            return intervals;

        // Sort by ascending starting point using an anonymous Comparator
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                return Integer.valueOf(i1.start).compareTo(i2.start);
            }
        });

        List<Interval> result = new LinkedList<Interval>();
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;

        for (Interval interval : intervals) {
            if (interval.start <= end) // Overlapping intervals, move the end if needed
                end = Math.max(end, interval.end);
            else {                     // Disjoint intervals, add the previous one and reset bounds
                result.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }

        // Add the last interval
        result.add(new Interval(start, end));
        return result;
    }

    public static class Interval {
        public int start;
        public int end;

        public Interval() {
            start = 0;
            end = 0;
        }

        public Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    static class IntervalComparator implements Comparator<Interval> {

        @Override
        public int compare(Interval o1, Interval o2) {
            if (o1.start == o2.start) {
                return 0;
            } else if (o1.start < o2.start) {
                return -1;
            } else {
                return 1;
            }
        }
    }
}
