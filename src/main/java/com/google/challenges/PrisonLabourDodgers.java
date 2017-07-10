package com.google.challenges;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by ritesh on 25/6/17.
 */
public class PrisonLabourDodgers {
    public static void main(String[] args) {
        int[] x = {13, 5, 15, 2, 5};
        int[] y = {5, 2, 5, 13};
        System.out.println(answer(x,y));
    }

    public static int answer(int[] x, int[] y){

        List<Integer> listX = convertToArrayList(x);
        List<Integer> listY = convertToArrayList(y);
        List<Integer> temp;
        int i;

        Collections.sort(listX);
        Collections.sort(listY);

        //ensuring bigger list stored in listX
        if (listX.size() < listY.size()){
            temp = listX;
            listX = listY;
            listY = temp;
        }

        for (i = 0; i < listY.size(); i++) {
            if (listX.get(i).compareTo(listY.get(i)) != 0)
                return listX.get(i);
        }

        return listX.get(i);
    }
    private static ArrayList<Integer> convertToArrayList(int[] array){
        ArrayList<Integer> objects = new ArrayList<>();
        for (int element : array)
            objects.add((Integer) element);
        return objects;
    }

}
