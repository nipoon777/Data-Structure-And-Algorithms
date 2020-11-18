package DynamicProgramming;

import java.util.*;

public class PaintFence {

    public static void main(String[] args)  {
        Scanner scn = new Scanner(System.in);
        
        int nfences = scn.nextInt();
        int ncolors = scn.nextInt();
        
        int sameII = ncolors;
        int difIJ = ncolors * (ncolors - 1);
        int total = sameII + difIJ;
        
        for(int nfence = 3 ; nfence <= nfences ; nfence++){
            sameII = difIJ;
            difIJ = total * (ncolors - 1);
            total = sameII + difIJ;
        }
        
        System.out.println(total);

        scn.close();

    }
}
