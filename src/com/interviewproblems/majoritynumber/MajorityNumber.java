package com.interviewproblems.majoritynumber;

/**
 * Created by titan-developer on 9/13/14.
 * <p/>
 * This algorithm, which Bob Boyer and I invented in 1980 decides which element of a sequence is in the majority,
 * provided there is such an element. How would you determine the majority element
 * (the count of the element is bigger the half of the size of array) of:
 * sequence:  A A A C C B B C C C B C C
 */
public class MajorityNumber {

    static int[] array = {1, 4, 3, 4, 3, 4, 5, 4, 1, 4, 1, 4, 4};

    public static void main(String[] strings) {
        MajorityNumber majorityNumber = new MajorityNumber();
        System.out.println(majorityNumber.findMajorityNumber(array));
    }

    public boolean findMajorityNumber(int[] array) {

        if (array == null) {
            return false;
        }

        int vote = 0;
        int majorityNumber = -1;

        for (int i : array) {
            if (vote <= 0) {
                majorityNumber = i;
                vote++;
            } else {
                if (i == majorityNumber) {
                    vote++;
                } else {
                    vote--;
                }
            }
        }

        int count = 0;

        for (int i : array) {
            if (i == majorityNumber) {
                count++;
            }
        }

        if (count > array.length / 2) {
            System.out.println(majorityNumber);
            return true;
        } else {
            return false;
        }
    }
}
