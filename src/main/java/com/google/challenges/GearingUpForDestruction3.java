package com.google.challenges;

import java.util.Arrays;

/**
 * Created by ritesh on 26/6/17.
 */
public class GearingUpForDestruction3 {

    public static void main(String[] args) {
        //int[] a = {4, 35, 52, 65, 78, 82};
        int[] a = {4, 100, 200, 300, 400};

        Arrays.stream(answer(a)).forEach(System.out::println);
    }
    public static int[] answer(int[] pegs) {
        int[] ans = {-1, -1}, gearSizes = new int[pegs.length];
        int max;
        boolean flag = false;

        max = pegs[1] - pegs[0] -1;

        for (int x = 1; x <= max; x++) {
            flag = false;
            gearSizes[0] = x;

            for (int j = 1; j < pegs.length ; j++) {
                gearSizes[j] = pegs[j] - pegs[j-1] - gearSizes[j-1];
                if (gearSizes[j] <= 0)
                    flag = true;
            }
            if (flag)
                continue;

            if (x == 2*gearSizes[pegs.length - 1])
                return new int[]{x, 1};

            if (x+1 == 2*gearSizes[pegs.length - 1])
                return new int[]{(x*3)+1, 3};

            if (x+2 == 2*gearSizes[pegs.length - 1])
                return new int[]{(x*3)+2, 3};
        }


        return ans;
    }
}
