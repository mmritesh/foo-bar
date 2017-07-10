package com.google.challenges;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.ArrayList;

/**
 * Created by ritesh on 8/7/17.
 */
public class PassTheCodedMessage2 {
    public static void main(String[] args) {
        int[] a = {3, 1, 4, 1, 5, 9};

        System.out.println(answer(a));
    }
    public static int answer(int[] l) {
        List<Integer> originalList = convertToArrayList(l);
        Queue<Integer> q0, q1, q2;

        q0 = new LinkedList<>();
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();

        Integer sum=0, rem, n1, n2;

        Collections.sort(originalList);
        Collections.reverse(originalList);

        for (Integer num : originalList) {
            rem = num % 3;
            if (rem == 0)
                q0.add(num);
            else {
                if (rem == 1) {
                    logic(q0, q1, q2, num);
                } else {                    //reminder = 2
                    logic(q0, q2, q1, num);
                }
            }
        }

        originalList = new ArrayList<>(q0);
        rearrange(originalList,q1,q2);
        Collections.sort(originalList);
        Collections.reverse(originalList);
        return calculateNumber(originalList);
    }
    private static void logic(Queue<Integer> q0, Queue<Integer> q1, Queue<Integer> q2, Integer num){
        Integer n1, n2, n3;
        if (q1.isEmpty()){
            if (q2.isEmpty())
                q1.add(num);
            else{
               n1 = q2.remove();
               q0.add(n1);
               q0.add(num);
            }
        }else{
            if (q1.size() == 1)
                q1.add(num);

            else {
                n1 = q1.remove();
                n2 = q1.remove();
                q0.add(num);
                q0.add(n1);
                q0.add(n2);
            }
        }
    }
    private static int calculateNumber(List<Integer> originalList){
        int len = originalList.size(), finalNumber = 0;
        int i=0;
        for (int num : originalList) {
            finalNumber += num * (Math.pow(10, len - i - 1));
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
    private static void rearrange(List q0, Queue<Integer> q1, Queue<Integer> q2){

        if (q1.size() == 2){
            for (int i = 2; i < 10 ; i+=3) {
                if(q0.contains(i)){
                    q0.remove((Integer)i);
                    q0.addAll(q1);
                }
            }
        }
        if (q2.size() == 2){
            for (int i = 1; i < 10 ; i+=3) {
                if(q0.contains(i)){
                    q0.remove((Integer)i);
                    q0.addAll(q2);
                }
            }
        }
    }
}
