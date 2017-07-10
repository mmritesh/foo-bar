package com.google.challenges;

import java.util.Arrays;

/**
 * Created by ritesh on 25/6/17.
 */
public class GearingUpForDestruction2 {
    public static void main(String[] args) {
        int[] a = {5};

        Arrays.stream(answer(a)).forEach(System.out::println);
    }
    public static int[] answer(int[] pegs) {
        int[] ans = {-1, -1},  diff = new int[pegs.length - 1];
        int sum = 0, toggle = 1, i;

        for (i = 1; i < pegs.length; i++) {
            diff[i-1] = pegs[i] - pegs[i-1];
            //if (diff[i-1] <= 0)
            //    return ans;
            sum = sum + toggle * diff[i-1];
            toggle = -1 * toggle;
        }
        if (sum <= 0)
            return ans;

        if (pegs.length % 2 != 0){
                ans[0] = 2 * sum;
                ans[1] = 1;

        }else{
            if (checkValid(2 * sum / 3, pegs)) {
                if ((2 * sum) % 3 == 0) {
                    ans[0] = 2 * sum / 3;
                    ans[1] = 1;
                } else {
                    ans[0] = 2 * sum;
                    ans[1] = 3;
                }
            }
        }
        return ans;
    }
    private static boolean checkValid(float firstGear, int[] pegs){
        float[] gears = new float[pegs.length];

        gears[0] = firstGear;

        for (int i = 1; i < pegs.length; i++) {
            gears[i] = pegs[i] - pegs[i-1] - gears[i-1];
            if (gears[i] <= 0)
                return false;
        }
        return true;
    }
}
