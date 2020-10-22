package RecursionWayUp;

import java.util.*;

public class PrintMazePath {
    public static void main(String[] args){
	        
        Scanner scn = new Scanner(System.in);
        int dr = scn.nextInt();
        int dc = scn.nextInt();
        
        printMazePaths(1, 1, dr, dc, "");
        
        scn.close();

    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static void printMazePaths(int sr, int sc, int dr, int dc, String psf) {
        if(sr == dr && sc == dc){
            System.out.println(psf);
            return;
        }
        //Horizontal Direction
        if(sc <= dc){
        printMazePaths(sr, sc + 1, dr, dc, psf + "h" );
        }
        
        if(sr <= dr){
        printMazePaths(sr + 1, sc, dr, dc, psf + "v");
        }
    }
    
}
