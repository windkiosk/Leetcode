package com.interviewproblems;

import java.util.*;

/**
 * Created by titan-developer on 1/19/15.
 * In Google Interview once this question was asked. You are given an array A containing some numbers.
 * You need to write the following two functions.
 *
 * int allocate() -> allocates a number randomly from the list and
 * once the number has been allocated it cannot be reallocated.
 *
 * int deallocate() -> takes a number as input and deallocates that number,
 * such that it can now be allocated in subsequent random number list.
 */
public class AllocateDeallocate {

    public static void main(String[] strings) {
        AllocateDeallocate allocateDeallocate = new AllocateDeallocate(8);

        int[] a = new int[5];
        for (int i = 0 ; i < a.length; i ++) {
            a[i] = allocateDeallocate.allocate();
        }

        for (int i = 0; i < a.length; i ++) {
            allocateDeallocate.deallocate(a[i]);
        }

    }

    int size, end;
    int[] arr;
    Random random;
    HashMap<Integer, Set<Integer>> map;
    public AllocateDeallocate(int size) {
        map = new HashMap<Integer, Set<Integer>>();
        random = new Random();
        //arr = new int[]{1, 2, 2, 3, 3, 5, 6, 7};
        arr = new int[size];
        for (int i = 0; i < size; i ++)
            arr[i] = random.nextInt(size * 3);
        this.size = size;
        end = size;
    }

    int allocate() {
        if (end == 0) return Integer.MIN_VALUE;
        int index = random.nextInt(end);
        int num = arr[index];
        //swap
        arr[index] = arr[end - 1];
        arr[end - 1] = num;
        end --;
        Set<Integer> indice;
        if (map.containsKey(num)) {
            indice = map.get(num);
        } else {
            indice = new HashSet<Integer>();
            map.put(num, indice);
        }
        indice.add(end);
        map.put(num, indice);
        return num;
    }

    void deallocate(int num) {
        if (end == size) return;
        if (map.containsKey(num)) {
            Set<Integer> indice = map.get(num);
            Iterator<Integer> iterator = indice.iterator();

            int lastIndex = iterator.next();
            iterator.remove();
            int in = arr[lastIndex];
            int out = arr[end];
            arr[end] = in;
            arr[lastIndex] = out;

            if (indice.size() == 0) map.remove(num);

            if (in != out) {
                indice = map.get(out);
                indice.add(lastIndex);
                indice.remove(end);
            }
            end ++;
        }
    }
}
