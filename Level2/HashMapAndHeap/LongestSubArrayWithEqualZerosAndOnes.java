import java.util.*;

public class Main {

    public static int solution(int[] arr) {
        // write your code here
        
        for(int i = 0 ; i < arr.length ; i++ ){
            if( arr[i] == 0 ){
                arr[i] = -1;
            }
        }
        
        

        return solveZeroSum(arr);
    }
    
    public static int solveZeroSum( int[] arr ){
        HashMap <Integer, Integer> hmap = new HashMap<>();
        
        int prefixSum = 0;
        
        int maxLen = 0;
        
        hmap.put( 0, -1 );
        
        for(int i = 0 ; i < arr.length ; i++ ){
            prefixSum += arr[i];
            
            if( hmap.containsKey(prefixSum) ){
                int fidx = hmap.get(prefixSum);
                
                maxLen = Math.max(maxLen, i - fidx );
            }else{
                hmap.put(prefixSum, i);
            }
            
            
        }
        
        return maxLen;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        System.out.println(solution(arr));
    }

}
