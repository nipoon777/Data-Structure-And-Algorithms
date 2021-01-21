package HashMap;

import java.util.*;

public class LongstCQ {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        getLargestSQ(arr);
    }

    public static void getLargestSQ(int[] arr) {
        HashMap < Integer, Boolean > map = new HashMap < > ();

        for (int val: arr) {
            map.put(val, true);
        }

        for (int val: arr) {
            if (map.containsKey(val - 1)) {
                map.put(val, false);
            }
        }

        int ml = 0;
        int msp = 0;
        for (int val: arr) {

            if (map.get(val)) {
                int tl = 1;

                while (map.containsKey(val + tl)) {
                    tl++;
                }
                if (tl > ml) {
                    ml = tl;
                    msp = val;
                }
            }
        }

        for (int i = 0; i < ml; i++) {
            System.out.println(msp + i);
        }

    }

}
