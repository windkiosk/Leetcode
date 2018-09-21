package com.leetcode.maxpointsonline;


import java.util.HashMap;
import java.util.Iterator;

/**
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 * https://oj.leetcode.com/problems/max-points-on-a-line/
 */
public class MaxPointOnLine {

    public static void main(String[] strings) {
        Point[] points = initTestPoints3();
        MaxPointOnLine maxPointOnLine = new MaxPointOnLine();
        int max = maxPointOnLine.maxPoints2(points);
        System.out.println(max);

        int a = 5;
        System.out.println(a);
        System.out.println(~a);
        System.out.println(Integer.toBinaryString(-6));
    }

    private static Point[] initTestPoints3() {
        Point[] points = new Point[3];

        points[0] = new Point(2, 3);
        points[1] = new Point(3, 3);
        points[2] = new Point(-5, 3);

        return points;
    }

    private static Point[] initTestPoints2() {
        Point[] points = new Point[4];

        points[0] = new Point(1, 1);
        points[1] = new Point(1, 1);
        points[2] = new Point(2, 2);
        points[3] = new Point(2, 2);

        return points;
    }

    private static Point[] initTestPoints() {
        Point[] points = new Point[9];

        points[0] = new Point(1, 0);
        points[1] = new Point(2, 1);
        points[2] = new Point(0, -1);

        points[3] = new Point(10, 1);
        points[4] = new Point(10, 2);

        points[5] = new Point(5, 5);
        points[6] = new Point(6, 5);

        points[7] = new Point(0, -2);
        points[8] = new Point(2, 2);

        return points;
    }

    public int maxPoints2(Point[] points) {
        int res = 0;
        for (int i = 0; i < points.length; i++) {
            int dup = 1;
            HashMap<Double, Integer> mp = new HashMap<Double, Integer>();
            for (int j = i + 1; j < points.length; j++) {
                if (points[i].x == points[j].x && points[i].y == points[j].y)
                    dup++;
                else if (points[i].x == points[j].x) {
                    int v = mp.containsKey((double)Integer.MAX_VALUE) ? mp.get((double) Integer.MAX_VALUE) : 0;
                    mp.put((double) Integer.MAX_VALUE, v + 1);
                }
                else {
                    double key = points[i].y == points[j].y ? 0.0d : (double) (points[i].y - points[j].y) / (double) (points[i].x - points[j].x);
                    int v = mp.containsKey(key) ? mp.get(key) : 0;
                    mp.put(key, v + 1);
                }
            }
            Iterator<Integer> iter = mp.values().iterator();
            int max = 0;
            while (iter.hasNext())
                max = Math.max(max, iter.next());
            max += dup;
            res = Math.max(max, res);
        }
        return res;
    }

    public int maxPoints(Point[] points) {
        //duplicate points, vertical line, 0.0d
        if (points == null || points.length == 0) return 0;
        HashMap<Double, Integer> map = new HashMap<Double, Integer>();
        int ret = 0;
        for (int i = 0; i < points.length; i ++) {
            map.clear();
            int dup = 1;
            for (int j = i + 1; j < points.length; j ++) {
                if (i == j) continue;
                //same points
                if (points[i].x == points[j].x && points[i].y == points[j].y) {
                    dup ++;
                } else {
                    double slope = calcSlope(points[i], points[j]);
                    int count = map.containsKey(slope) ? map.get(slope) : 0;
                    count++;
                    map.put(slope, count);
                }
            }
            if (dup > ret) ret = dup;
            Iterator<Integer> iterator = map.values().iterator();
            while(iterator.hasNext()) {
                int count = iterator.next();
                if (count + dup > ret) ret = count + dup;
            }
        }
        return ret;
    }

    double calcSlope(Point a, Point b) {
        if (a.x == b.x) return Double.MAX_VALUE;
        if (a.y == b.y) return 0.0d;
        return (double) (a.y - b.y) / (double) (a.x - b.x);
    }
    /**
     * Definition for a point.
     */
    static class Point {
        int x;
        int y;

        Point() {
            x = 0;
            y = 0;
        }

        Point(int a, int b) {
            x = a;
            y = b;
        }
    }

}
