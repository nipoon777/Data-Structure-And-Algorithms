import java.util.*;

public class PathOfSnake {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int m = scn.nextInt();

        int count = countPath(n, m);
        System.out.println("Count :", count);

        printAllPaths(n, m,"");
        System.out.println(getAllPaths(n, m));

    }

    public static void printAllPaths(int n, int m , String asf){
        if( n < 0 ){
            return;
        }
        if( n == 0){
            System.out.println(asf);
            return;
        }

        for(int face = 1 ; face <= m ; face++ ){
            printAllPaths(n - face, m, asf + face);
        }
    }

    public static ArrayList<String> getAllPaths(int n, int m){
        if( n < 0 ){
            return new ArrayList<>();
        }
        if( n == 0){
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }


        ArrayList<String> resp = new ArrayList<>();
        for(int face = 1 ; face <= m ; face++ ){
            resp = getAllPaths(n - face, m);
            if( resp.length > 0){
                resp.add(face);
            }
        }
        return resp;

    }


    public static int countPath(int n, int m){
        if( n < 0 ){
            return 0;
        }
        if( n == 0){
            return 1;
        }
        int count = 0;
        for(int face = 1 ; face <= m ; face++ ){
            count += countPath(n - face, m);
        }
        return count;
    }
    
}
