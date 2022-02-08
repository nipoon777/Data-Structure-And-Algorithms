import java.util.*;

public class Main {
	
	public static void solution(int[] arr, int k){
		HashMap< Integer, Integer > remFreq = new HashMap<>();
		
		for(int val : arr ){
		    int rem = val % k;
		    remFreq.put(rem, remFreq.getOrDefault(rem, 0) + 1);
		}
		
		for( int rem : remFreq.keySet() ){
		    if( rem == 0 ){
		        if( remFreq.get(rem) % 2 == 1 ){
		            System.out.println("false");
		            return;
		        }
		    }else if ( rem * 2 == k ){
		        if( remFreq.get(rem) % 2 == 1 ){
		            System.out.println("false");
		            return;
		        }
		    }else{
		        int rem1 = remFreq.get(rem);
		        
		        if( remFreq.get(k - rem) == null ){
		            System.out.println("false");
		            return;
		        }
		        int rem2 = remFreq.get(k - rem);
		        if( rem1 != rem2 ){
		            System.out.println("false");
		            return;
		        }
		        
		    }
		}
		
		System.out.println("true");

	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i = 0 ; i < n; i++){
			arr[i] = scn.nextInt();
		}
		int k = scn.nextInt();
		solution(arr,k);
	}

}
