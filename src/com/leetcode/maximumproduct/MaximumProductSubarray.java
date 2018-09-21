package com.leetcode.maximumproduct;

import java.util.LinkedList;

/**
 * Created by titan-developer on 10/22/14.
 * https://oj.leetcode.com/problems/maximum-product-subarray/
 */
public class MaximumProductSubarray {

    public static void main(String[] strings) {
        int[] a = {2, -3, -4, -5, -7, -2, 6, -1};
        //int[] a = {-3, -4, -5, -7, -1, 6, 7};
        //int[] a = {-3, -4, -5, 2, 3, -1, -2};
        //int[] a = {-3, -4, -5, 0, 3, -1, -2};
        //int[] a = {-3, 4, 0, -1, 3, 0, -1, 2};

        MaximumProductSubarray maxProduct = new MaximumProductSubarray();
        System.out.println(maxProduct.maxProduct(a));
    }

    public int maxProduct(int arr[]) {
        // max positive product ending at the current position
        int max_ending_here = 1;

        // min negative product ending at the current position
        int min_ending_here = 1;

        // Initialize overall max product
        int max_so_far = 1;

        /* Traverse throught the array. Following values are maintained after the ith iteration:
           max_ending_here is always 1 or some positive product ending with arr[i]
           min_ending_here is always 1 or some negative product ending with arr[i] */
        for (int i = 0; i < arr.length; i++) {
            /* If this element is positive, update max_ending_here. Update
               min_ending_here only if min_ending_here is negative */
            if (arr[i] > 0) {
                max_ending_here = max_ending_here * arr[i];
                min_ending_here = Math.min(min_ending_here * arr[i], 1);
            }

            /* If this element is 0, then the maximum product cannot
               end here, make both max_ending_here and min_ending_here 0
               Assumption: Output is alway greater than or equal to 1. */
            else if (arr[i] == 0) {
                max_ending_here = 1;
                min_ending_here = 1;
            }

            /* If element is negative. This is tricky
               max_ending_here can either be 1 or positive. min_ending_here can either be 1
               or negative.
               next min_ending_here will always be prev. max_ending_here * arr[i]
               next max_ending_here will be 1 if prev min_ending_here is 1, otherwise
               next max_ending_here will be prev min_ending_here * arr[i] */
            else {
                int temp = max_ending_here;
                max_ending_here = Math.max(min_ending_here * arr[i], 1);
                min_ending_here = temp * arr[i];
            }

            System.out.println(max_ending_here + ", " + min_ending_here);

            // update max_so_far, if needed
            if (max_so_far < max_ending_here)
                max_so_far = max_ending_here;
        }

        return max_so_far;
    }

    public int maxProduct2(int A[]) {
        if (A.length == 0) return 0;
        int maxProduct = A[0];
        int minProduct = A[0];
        int maxRes = A[0];
        for (int i = 1; i < A.length; i++) {
            if (A[i] >= 0) {
                maxProduct = Math.max(maxProduct * A[i], A[i]);
                minProduct = Math.min(minProduct * A[i], A[i]);
            } else {
                int temp = maxProduct;
                maxProduct = Math.max(minProduct * A[i], A[i]);
                minProduct = Math.min(temp * A[i], A[i]);
            }
            maxRes = Math.max(maxRes, maxProduct);
        }
        return maxRes;
    }

    public int maxProduct3(int[] A) {
        if (A.length == 0) {
            return 0;
        }

        int maxherepre = A[0];
        int minherepre = A[0];
        int maxsofar = A[0];
        int maxhere, minhere;

        for (int i = 1; i < A.length; i++) {
            maxhere = Math.max(Math.max(maxherepre * A[i], minherepre * A[i]), A[i]);
            minhere = Math.min(Math.min(maxherepre * A[i], minherepre * A[i]), A[i]);
            maxsofar = Math.max(maxhere, maxsofar);
            maxherepre = maxhere;
            minherepre = minhere;
        }
        return maxsofar;
    }

    public int maxProductMine(int[] array) {
        int maxProduct = Integer.MIN_VALUE;

        if (array == null || array.length < 2) {
            return maxProduct;
        }

        LinkedList<Segment> segmentsList = new LinkedList<Segment>();
        int currentProduct = 0;

        int currentStatus = Integer.MIN_VALUE;
        Segment segment = null;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                if (maxProduct < 0) {
                    maxProduct = 0;
                }

                if (segment == null) {
                    currentProduct = 0;
                } else {
                    addAndMerge(segmentsList, segment);
                    currentProduct = getMaxProductValue(segmentsList, array);
                }
                if (currentProduct > maxProduct) {
                    maxProduct = currentProduct;
                }
                segmentsList.clear();
                currentStatus = Integer.MIN_VALUE;
            } else if (array[i] > 0) {
                if (currentStatus == Integer.MIN_VALUE) {
                    currentStatus = 1;
                    segment = new Segment();
                    segment.start = i;
                    segment.end = i;
                    segment.isPositive = true;
                } else if (currentStatus > 0) {
                    segment.end = i;
                } else {
                    Segment ori = addAndMerge(segmentsList, segment);
                    if (segmentsList.size() == 3) {
                        currentProduct = getMaxProductValue(segmentsList, array);
                        if (currentProduct > maxProduct) {
                            maxProduct = currentProduct;
                        }
                    }

                    if (ori == null) {
                        currentStatus = 1;
                        segment = new Segment();
                        segment.start = i;
                        segment.end = i;
                        segment.isPositive = true;
                    } else {
                        segment = ori;
                        segment.end = i;
                    }

                }
            } else {

                if (currentStatus == Integer.MIN_VALUE) {
                    currentStatus = -1;
                    segment = new Segment();
                    segment.start = i;
                    segment.end = i;
                    segment.isPositive = false;
                } else if (currentStatus > 0) {
                    segmentsList.add(segment);
                    if (segmentsList.size() == 3) {
                        currentProduct = getMaxProductValue(segmentsList, array);
                        if (currentProduct > maxProduct) {
                            maxProduct = currentProduct;
                        }
                    }

                    currentStatus = -1;
                    segment = new Segment();
                    segment.start = i;
                    segment.end = i;
                    segment.isPositive = false;
                } else {
                    segment.end = i;
                }
            }
        }

        if (segment != null) {
            addAndMerge(segmentsList, segment);
        }

        currentProduct = getMaxProductValue(segmentsList, array);
        if (currentProduct > maxProduct) {
            maxProduct = currentProduct;
        }

        return maxProduct;
    }

    private Segment addAndMerge(LinkedList<Segment> cursorsList, Segment segment) {
        if (segment.isPositive) {
            cursorsList.add(segment);
        } else {
            if ((segment.end - segment.start + 1) % 2 == 0) {
                segment.isPositive = true;

                if (cursorsList.peekLast() != null) {
                    Segment ori = cursorsList.peekLast();
                    ori.end = segment.end;
                    return ori;
                } else {
                    cursorsList.add(segment);
                }

            } else {
                cursorsList.add(segment);
            }
        }

        return null;
    }

    private int getMaxProductValue(LinkedList<Segment> cursorsList, int[] array) {
        int product = 1;
        if (cursorsList.size() == 0)
            return product;

        if (cursorsList.size() == 1) {
            Segment segment = cursorsList.peekFirst();
            if (segment.start == segment.end) {
                return product;
            }

            if (segment.isPositive) {
                product = 1;
                for (int i = segment.start; i <= segment.end; i++) {
                    product *= array[i];
                }
            } else {
                if (array[segment.end] < array[segment.start]) {
                    for (int i = segment.start + 1; i <= segment.end; i++) {
                        product *= array[i];
                    }
                } else {
                    for (int i = segment.start + 1; i <= segment.end - 1; i++) {
                        product *= array[i];
                    }
                }
            }
        } else if (cursorsList.size() == 2) {
            Segment segment1 = cursorsList.pollFirst();
            Segment segment2 = cursorsList.pollFirst();

            if (segment1.start == segment1.end && segment2.start == segment2.end) {
                product = array[segment1.start] * array[segment2.start];
            } else if (segment1.isPositive) {
                for (int i = segment1.start; i <= segment2.end - 1; i++) {
                    product *= array[i];
                }
                segment1.end = segment2.end - 1;
                segment2.start = segment2.end;
                cursorsList.add(segment1);
                cursorsList.add(segment2);
            } else {
                for (int i = segment1.start + 1; i <= segment2.end; i++) {
                    product *= array[i];
                }
                segment1.end = segment1.start;
                segment2.start = segment1.start + 1;
                cursorsList.add(segment1);
                cursorsList.add(segment2);
            }
        } else if (cursorsList.size() == 3) {
            Segment segment1 = cursorsList.pollFirst();
            Segment segment2 = cursorsList.pollFirst();
            Segment segment3 = cursorsList.pollFirst();

            if (segment1.isPositive) {
                int value1 = 1, value3 = 1;

                for (int i = segment1.start; i <= segment1.end; i++) {
                    value1 *= array[i];
                }

                for (int i = segment3.start; i <= segment3.end; i++) {
                    value3 *= array[i];
                }

                if (Math.abs(value1 * segment2.start) > Math.abs(value3 * segment2.end)) {
                    for (int i = segment2.start; i <= segment2.end - 1; i++) {
                        value1 = value1 * array[i];
                    }
                    product = value1;
                    segment1.end = segment2.end - 1;
                    segment2.start = segment2.end;
                    segment2.end = segment3.end;
                    cursorsList.add(segment1);
                    cursorsList.add(segment2);
                } else {
                    for (int i = segment2.start + 1; i < segment2.end; i++) {
                        value3 = value3 * array[i];
                    }
                    product = value3;
                    segment1.end = segment2.start;
                    segment1.isPositive = false;
                    segment3.start = segment2.start + 1;
                    cursorsList.add(segment1);
                    cursorsList.add(segment3);
                }
            } else {
                for (int i = segment1.start; i <= segment3.end; i++) {
                    product *= array[i];
                }
                segment1.end = segment3.end;
                cursorsList.add(segment1);
            }
        }

        return product;
    }

    class Segment {
        boolean isPositive = false;

        int start = 0;
        int end = 0;
    }
}
