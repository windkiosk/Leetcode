package com.leetcode.insertinterval;

import com.leetcode.mergeintervals.MergeIntervals;
import com.leetcode.mergeintervals.MergeIntervals.Interval;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by titan-developer on 11/4/14.
 * https://oj.leetcode.com/problems/insert-interval/
 */
public class InsertInterval {

    //Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

    //This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].

    public static void main(String[] strings) {
        List<Interval> intervals = new ArrayList<Interval>();
        intervals.add(new Interval(1, 5));
        intervals.add(new Interval(6, 8));
//        intervals.add(new Interval(6, 7));
//        intervals.add(new Interval(8, 10));
//        intervals.add(new Interval(12, 16));

        InsertInterval insert = new InsertInterval();
        intervals = insert.insert(intervals, new Interval(5, 6));

        for (Interval interval : intervals) {
            System.out.print("[" + interval.start + ", " + interval.end + "], ");
        }
    }

    public List<Interval> insert3rd(List<Interval> intervals, Interval newInterval) {
        List<Interval> results = new ArrayList<Interval>();
        if (intervals == null || intervals.size() == 0) {
            results.add(newInterval);
            return results;
        }

        int start = 0, end = 0;

        for (Interval i : intervals) {
            if (newInterval.start > i.end) start++;
            if (newInterval.end >= i.start) end++;
            else break;
        }

        if (start == end) {
            results.addAll(intervals);
            results.add(start, newInterval);
            return results;
        }

        for (int i = 0; i < start; i++)
            results.add(intervals.get(i));
        Interval interval = new Interval(Math.min(newInterval.start, intervals.get(start).start), Math.max(newInterval.end, intervals.get(end - 1).end));
        results.add(interval);
        for (int i = end; i < intervals.size(); i++)
            results.add(intervals.get(i));

        return results;
    }

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (intervals == null || intervals.size() == 0) {
            intervals = new ArrayList<Interval>();
            intervals.add(newInterval);
            return intervals;
        }

        int index = 0;
        int leftIndex = -1;
        int rightIndex = -1;
        for (int i = 0; i < intervals.size(); i ++) {
            Interval current = intervals.get(i);

            if (leftIndex == -1) {
                if (newInterval.start < current.start) {
                    leftIndex = index;
                } else if (newInterval.start <= current.end) {
                    leftIndex = index + 1;
                }
            }

            if (rightIndex == -1) {
                if (newInterval.end < current.start) {
                    rightIndex = index;
                } else if (newInterval.end <= current.end) {
                    rightIndex = index + 1;
                }
            }

            index += 2;

            if (leftIndex != -1 && rightIndex != -1) {
                break;
            }
        }

        if (leftIndex == -1) {
            leftIndex = intervals.size() * 2;
        }

        if (rightIndex == -1) {
            rightIndex = intervals.size() * 2;
        }

        if (leftIndex == rightIndex) {
            if (leftIndex % 2 == 0) {
                intervals.add(leftIndex / 2, newInterval);
            }
        } else {
            int start, end;
            int mergeLeftBorder = leftIndex / 2;
            int mergeRightBorder;

            if (leftIndex % 2 == 0) {
                start = newInterval.start;
            } else {
                start = intervals.get(mergeLeftBorder).start;
            }

            if (rightIndex % 2 == 0) {
                mergeRightBorder = rightIndex / 2 - 1;
                end = newInterval.end;
            } else {
                mergeRightBorder = rightIndex / 2;
                end = intervals.get(mergeRightBorder).end;
            }

            for (int i = mergeRightBorder; i >= mergeLeftBorder; i --) {
                intervals.remove(i);
            }

            newInterval.start = start;
            newInterval.end = end;

            intervals.add(mergeLeftBorder, newInterval);
        }

        return intervals;
    }
}
