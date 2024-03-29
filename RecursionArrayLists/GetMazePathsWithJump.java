package RecursionArrayLists;
import java.util.*;

public class GetMazePathsWithJump {
    public static void main(String[] args)  {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        
        ArrayList<String> paths = getMazePaths(1, 1, n, m);
        System.out.println(paths);

        scn.close();

    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {
        
        
        if( sr == dr && sc == dc){
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }
        ArrayList<String> paths = new ArrayList<>();
        
        //horizontal Path
        for(int ms = 1 ; ms <= dc - sc ; ms++){
            ArrayList<String> hpaths = getMazePaths(sr, sc + ms , dr, dc);
            for(String hpath : hpaths){
                paths.add("h" + ms + hpath);
            }
        }

        //vertical Path
        for(int ms = 1 ; ms <= dr - sr ; ms++){
            ArrayList<String> vpaths = getMazePaths(sr + ms, sc, dr, dc);
            for(String vpath : vpaths){
                paths.add("v" + ms + vpath);
            }
        }
        
        //Diagonal Path
        for(int ms = 1 ; ms <= dr - sr && ms <= dc - sc ; ms++){
            ArrayList<String> dpaths = getMazePaths(sr + ms, sc + ms, dr, dc);
            for(String dpath : dpaths){
                paths.add("d" + ms + dpath);
            }
        }
        
        return paths;
    }
    
}
