package RecursionWayUp;
import java.util.*;

public class PrintMazePathJ {
    public static void main(String[] args) throws Exception {
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
        
        //Horizontal Moves
        for(int ms = 1 ; ms <= dc - sc ; ms++){
            printMazePaths(sr, sc + ms, dr, dc, psf + "h" + ms);
        }
        //Verical Moves
        for(int ms = 1 ; ms <= dr - sr ; ms++){
            printMazePaths(sr + ms, sc, dr, dc, psf + "v" + ms);

        }
        //diagonal Moves
        for(int ms = 1 ; ms <= dc - sc  && ms <= dr - sr ; ms++){
            printMazePaths(sr + ms, sc + ms, dr, dc, psf + "d" + ms);
        }
        
    }
    
}
