package FunctionsAndArrays;
import java.util.*;

public class BarChart {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int [] arr = new int[n];
        
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = scn.nextInt();
        }
        int max = arr[0];
        for(int i = 1 ; i < arr.length ; i++){
            if( max <= arr[i])
                max = arr[i];
        }

        for(int i = max ; i > 0 ; i-- ){
            for(int j = 0 ; j < arr.length; j++){
                if(arr[j] >= i){
                    System.out.print("*\t");
                }
                else{
                    System.out.print("\t");
                }
            }
            System.out.println();
        }
        scn.close();


    }    
}
