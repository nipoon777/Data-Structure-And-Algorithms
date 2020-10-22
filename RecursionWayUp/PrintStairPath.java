package RecursionWayUp;
import java.util.*;


public class PrintStairPath {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        
        printStairPaths(n,"");
        
        scn.close();

    }

    public static void printStairPaths(int n, String path) {
        if(n == 0){
            System.out.println(path);
            return;
        }else if(n < 0){
            return;
        }
        
        
        for(int i = 1 ; i <= 3 ; i++){
            printStairPaths(n - i , path + i);
        }
    }
    
}
