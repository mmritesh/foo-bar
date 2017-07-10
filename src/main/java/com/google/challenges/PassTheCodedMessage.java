package com.google.challenges;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by ritesh on 8/7/17.
 */
public class PassTheCodedMessage {

    public static void main(String[] args) {
        int[] a = {4,3,3,1};

        System.out.println(answer(a));
    }

    public static int answer(int[] l) {
        List<Integer> originalList = convertToArrayList(l);
        Collections.sort(originalList);
        Collections.reverse(originalList);
        Integer[] list = originalList.toArray(new Integer[]{});

        int sum = getSum(l);
        int rem = sum % 3;
        int[] ignore = new int[l.length];


        int i = 0;

        if(rem != 0)
            for (int j = 0; j < list.length; j++) {
                if ((list[j] - rem)%3 == 0)
                    ignore[j] = 1;
            }

        return getMaxNumber(originalList, ignore);
    }

    private static int getSum(int[] a){
        int sum = 0;
        for (int i = 0; i < a.length; i++)
            sum += a[i];

        return sum;
    }
    private static int getMaxNumber(List<Integer> a, int[] ignore){
        int finalNumber = 0, len = 0;
        int i=0, p = 0;
        for (i = 0; i < ignore.length ; i++) {
            if (ignore[i] != 1)
                len++;
        }
        i=0;
        for (Integer num : a ) {
            if (ignore[i] != 1) {
                finalNumber += num * (Math.pow(10, len - p - 1));
                p++;
            }
            i++;
        }
        return finalNumber;
    }
    private static ArrayList<Integer> convertToArrayList(int[] array){
        ArrayList<Integer> objects = new ArrayList<>();
        for (int element : array)
            objects.add((Integer) element);
        return objects;
    }
}
