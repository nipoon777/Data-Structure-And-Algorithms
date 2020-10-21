package RecursionArrayLists;
import java.util.*;

public class StairCombination {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        ArrayList<String> res = getStairPaths(n);

        System.out.println(res);
        scn.close();
    }

    public static ArrayList<String> getStairPaths(int n)
    {
        if(n == 0){
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }else if ( n < 0){
            ArrayList<String> bres = new ArrayList<>();
            return bres;
        }
        ArrayList<String> paths = new ArrayList<>();

        ArrayList<String> path1 = getStairPaths(n - 1);
        ArrayList<String> path2 = getStairPaths(n - 2);
        ArrayList<String> path3 = getStairPaths(n - 3);

        for(String path : path1){
            paths.add( 1 + path);
        }

        for(String path : path2){
            paths.add( 2 + path);
        }

        for(String path : path3){
            paths.add( 3 + path);
        }

        return paths;
    }
    
}
