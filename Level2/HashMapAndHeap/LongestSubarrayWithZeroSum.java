import java.util.*;

public class Main {
	
	public static int solution(int[] arr) {
		// write your code here
        
        int prefixSum = 0;
        HashMap <Integer, Integer> hmap = new HashMap<>();
        
        hmap.put(0, -1);
        int maxLen = 0;
        
        for(int i = 0 ; i < arr.length ; i++ ){
            prefixSum += arr[i];
            
            if( hmap.containsKey(prefixSum) ){
                
                int fidx = hmap.get(prefixSum);
                maxLen = Math.max(i - fidx, maxLen);
                
            }else{
                hmap.put(prefixSum, i);
            }
        }
        
        
		return maxLen;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[scn.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		System.out.println(solution(arr));
	}

}
