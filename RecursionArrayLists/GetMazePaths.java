package RecursionArrayLists;
import java.util.*;


public class GetMazePaths {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int m = scn.nextInt();

        ArrayList<String> paths = getMazePaths(1, 1, n , m);

        System.out.println(paths);

        scn.close();
    }

    public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc){

        if(sr == dr && sc == dc){
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }

        ArrayList<String> hpaths = new ArrayList<>();
        ArrayList<String> vpaths = new ArrayList<>();

        if(sc < dc){
            hpaths = getMazePaths(sr , sc + 1, dr, dc);
        }

        if(sr < dr){
            vpaths = getMazePaths(sr + 1, sc, dr, dc);
        }

        ArrayList<String> res = new ArrayList<>();

        for(String hpath : hpaths){
            res.add("h" + hpath);
        }

        for(String vpath : vpaths){
            res.add("v" + vpath);
        }
        return res;

    }
    
}
