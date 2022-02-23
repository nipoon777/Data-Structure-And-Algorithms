import java.util.*;

public class Main {

    public static int solution(int[] arr, int k) {
        
        HashMap<Integer, Integer> hmap = new HashMap <>();
        hmap.put(0, 1);
        
        int preSum = 0;
        int count = 0;
        
        for(int i = 0 ; i < arr.length ; i++ ){
            preSum += arr[i];
            
            int rem = preSum % k;
            
            if( rem < 0 ) rem += k;
            
            if( hmap.containsKey(rem) ){
                int freq = hmap.get(rem);
                
                count += freq;
                
                hmap.put(rem, freq + 1);
                
            }else{
                hmap.put(rem, 1);
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
        int k = scn.nextInt();
        System.out.println(solution(arr, k));
    }

}
