package Patterns;

import java.util.*;

public class PrintP {

    public static void main(String[] args) {

        // write your code here.
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int row = 1, nst = n / 2, nsp = 0;

        while (row <= n) {
            for (int i = 1; i <= nst; i++) {
                System.out.print("*\t");
            }
            for (int i = 1; i <= nsp; i++) {
                System.out.print("\t");
            }
            if (row <= n / 2 + 1) {
                System.out.print("*\t");
            }

            System.out.println();

            if (row < n / 2) {
                nsp = n / 2;
                nst = 1;
            } else if (row == n / 2) {
                nst = n / 2;
                nsp = 0;
            } else {
                nst = 1;
                nsp = 0;
            }
            row++;

        }
    }
}
