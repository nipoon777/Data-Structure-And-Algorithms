package Level2.RecursionAndBackTrack;

import java.util.*;

public class Lexicograph {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
        scn.close();
        
		for(int i = 1 ; i <= 9 ; i++ ){
		    lexicograph(i, n);
		}
	}
	
	public static void lexicograph(int i, int n){
	    if( i > n ){
	        return;
	    }
	    
	    System.out.println(i);
	    
	    for(int j = 0 ; j < 10 ; j++ ){
	        lexicograph( (10 * i) + j, n);
	    }
	}
	
}
