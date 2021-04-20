package Level2.RecursionAndBackTrack;

import java.util.*;

public class GoldMine2 {
	static int max = 0;
	public static void getMaxGold(int[][] arr){
		//write your code here
		boolean[][] visited = new boolean[arr.length][arr[0].length];
		
		
		for(int i = 0 ; i < arr.length ; i++ ){
		    for(int j = 0 ; j < arr[0].length ; j++ ){
		        int sum = 0;
		        if(visited[i][j] == false && arr[i][j] != 0 ){
		            ArrayList<Integer> bag = new ArrayList<>();
		            
		            collectGold(i, j,arr, visited, bag);
		            
		            for(int val : bag){
		                sum += val;
		            }
		            
		            if(sum > max){
		                max = sum;
		            }
		        }
		        
		    }
		}
		
	}
	
	public static void collectGold(int r, int c, int[][] arr, boolean[][] visited, ArrayList<Integer> bag){
	    
	    if(r < 0 || c < 0 || r >= arr.length || c >= arr[0].length || visited[r][c] || arr[r][c] == 0){
	        return;
	    }
	    
	    visited[r][c] = true;
	    bag.add(arr[r][c]);
	    
	    collectGold(r -1, c, arr, visited, bag);
	    collectGold(r + 1, c, arr, visited, bag);
	    collectGold(r, c + 1, arr, visited, bag);
	    collectGold(r, c - 1, arr, visited, bag);
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int m = scn.nextInt();
		int[][] arr = new int[m][n];
		for(int i = 0; i < arr.length; i++){
			for(int j = 0 ; j  < arr[0].length; j++){
				arr[i][j] = scn.nextInt();
			}
		}
        scn.close();
		getMaxGold(arr);
		System.out.println(max);
	}
		
}
