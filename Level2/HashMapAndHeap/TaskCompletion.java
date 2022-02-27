import java.util.*;

public class Main {
	
    public static void completeTask(int n, int m, int[] arr) {
		// write your code here
		
		HashMap <Integer, Integer> workDone = new HashMap<>();
		
		for(int val : arr){
		    workDone.put(val, 1);
		}
		ArrayList<Integer> p1 = new ArrayList<>();
		ArrayList<Integer> p2 = new ArrayList<>();
		
		for(int i = 1 ; i <= n ; i++ ){
		    if( !workDone.containsKey(i) ){
		        if( p1.size() > p2.size() ){
		            p2.add(i);
		        }else{
		            p1.add(i);
		        }
		    }
		}
		
		for( int val : p1 ){
		    System.out.print(val +" ");
		}
		System.out.println();
		for( int val : p2 ){
		    System.out.print(val +" ");
		}
		
		System.out.println();

	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int m = scn.nextInt();
		int[] num = new int[m];
		for (int i = 0; i < m; i++) {
			num[i] = scn.nextInt();
		}
		completeTask(n, m, num);
	}

}
