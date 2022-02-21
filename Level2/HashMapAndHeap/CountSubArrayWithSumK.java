import java.util.*;

public class Main {

	public static int solution(int[] arr, int k){
		// write your code here
		HashMap <Integer, Integer> hmap = new HashMap<>();
		
		int count = 0;
		int prefixSum = 0;
		hmap.put(0, 1);
		
		for(int i = 0 ; i < arr.length ; i++ ){
		    prefixSum += arr[i];
		    
		    if( hmap.containsKey(prefixSum - k) ){
		        int freq = hmap.get(prefixSum - k);
		        count += freq;
		      //  hmap.put(prefixSum - k, freq + 1);
		    }
		    
		    hmap.put(prefixSum, hmap.getOrDefault(prefixSum, 0) + 1);
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n; i++){
            arr[i] = scn.nextInt();
        }
        int target = scn.nextInt();
        System.out.println(solution(arr,target));
	}

}
