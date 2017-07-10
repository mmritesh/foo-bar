package com.google.challenges;

import java.util.Arrays;

/**
 * Created by ritesh on 25/6/17.
 */
public class GearingUpForDestruction {

    public static void main(String[] args) {
        //int[] a = {4, 35, 52, 65, 78, 82};
        int[] a = {4, 100, 200, 300, 400};

        Arrays.stream(answer(a)).forEach(System.out::println);
    }
    public static int[] answer(int[] pegs) {
        int[] ans = new int[2], gears = new int[pegs.length], defaultAns = {-1, -1};
        int first, last, tempLast;

        gears[0] = (pegs[1] - pegs[0]) / 2;
        for (int i = 1; i < pegs.length; i++) {
            gears[i] = (pegs[i] - pegs[i-1]) - gears[i-1];
            if (gears[i] <= 0)
                return defaultAns;
        }
        first = gears[0];
        last = gears[pegs.length - 1];

        if (first <= last || last < 0)
            return defaultAns;

        if (pegs.length % 2 != 0){
                tempLast = last;
                last = first - last;
                first = first - (tempLast - last);

        }/*else{
            if ((float)first / last < 2){
                while ((float)first / last < 2) {
                    first++;
                    last--;
                }
            }else if ((float)first / last > 2){
                while ((float)first / last > 2){
                    first--;
                    last++;
                }
            }
            if (first / last != 2)
                return defaultAns;
        }*/
        ans[0] = first;
        ans[1] = 1;

        return ans;

    }
}
