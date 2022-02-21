import java.util.*;

public class Main {

    public static int solution(int[] arr) {
        // write your code here
        for(int i = 0 ; i < arr.length ; i++ ){
            if( arr[i] == 0 ){
                arr[i] = -1;
            }
        }
        return solveCountZero(arr);
    }
    
    public static int solveCountZero(int[] arr){
        int count = 0;
        
        HashMap <Integer, Integer> hmap = new HashMap <>();
        int prefixSum = 0;
        hmap.put(0, 1);
        
        for(int i = 0 ; i < arr.length ; i++ ){
            prefixSum += arr[i];
            
            if( hmap.containsKey(prefixSum) ){
                int freq = hmap.get(prefixSum);
                
                count += freq;
                
                hmap.put(prefixSum, freq + 1);
            }else{
                hmap.put(prefixSum, 1);
            }
        }
        
        return count;
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
