package Level2.RecursionAndBackTrack;
import java.util.*;

public class CrossWord {

	public static void solution(char[][] arr, String[] words, int vidx){
	    
	    if(vidx == words.length ){
	        print(arr);
	        return;
	    }
	    
		String word = words[vidx];
		
		
		for(int i = 0 ; i < arr.length ; i++ ){
		    for(int j = 0 ; j < arr[0].length ; j++){
		        if( arr[i][j] == '-' || arr[i][j] == word.charAt(0)){
		            if(canBePlacedHorizontally(arr, i, j, word) ){
		                boolean[] weplaced = placedHorizontally(arr, i, j, word);
		                
		                solution(arr, words, vidx + 1);
		                
		                unplaceHorizontally(arr, i, j, weplaced);
		            }
		            
		            if(canBePlacedVertically(arr, i, j, word) ){
		                boolean[] weplaced = placedVertically(arr, i, j, word);
		                
		                solution(arr, words, vidx + 1);
		                
		                unplaceVertically(arr, i, j, weplaced);
		            }
		        }
		    }
		}
	}
	
	public static boolean canBePlacedHorizontally(char[][] arr, int i, int j, String word ){
	    
	    if( j - 1 >= 0 && arr[i][j - 1] == '-'){
	        return false;
	    }else if ( j + word.length() < arr[0].length && arr[i][j + word.length()] == '-' ){
	        return false;
	    }else if ( j + word.length() > arr[0].length ){
	        return false;
	    }
	    
	    for(int jj = 0 ; jj < word.length() ; jj++ ){
	 
            if(arr[i][j + jj] == '-' || arr[i][j + jj] == word.charAt(jj) ){
                continue;
            }else{
                return false;
            }
	        
	        
	    }
	    return true;
	}
	
	public static boolean canBePlacedVertically(char[][] arr, int i, int j, String word ){
	    
	    if( i - 1 >= 0 && arr[i - 1][j] == '-'){
	        return false;
	    }else if ( i + word.length() < arr.length && arr[i + word.length()][j] == '-' ){
	        return false;
	    }else if ( i + word.length() > arr.length ){
	        return false;
	    }
	    
	    for(int ii = 0 ; ii < word.length() ; ii++ ){
            if(arr[i + ii][j] == '-' || arr[i +ii][j] == word.charAt(ii) ){
                continue;
            }else{
                return false;
            }
	    }
	    return true;
	}
	
	
	public static boolean[] placedHorizontally(char[][] arr, int i, int j, String word ){
	    boolean[] weplaced = new boolean[word.length()];
	    
	    for(int jj = 0 ; jj < word.length() ; jj++ ){
	        if(arr[i][j +jj] == '-'){
	            arr[i][j + jj] = word.charAt(jj);
	            weplaced[jj] = true;
	        }
	    }
	    return weplaced;
	}
	
	public static boolean[] placedVertically(char[][] arr, int i, int j, String word ){
	    boolean[] weplaced = new boolean[word.length()];
	    
	    for(int ii = 0 ; ii < word.length() ; ii++ ){
	        if(arr[i + ii][j] == '-'){
	            arr[i + ii][j] = word.charAt(ii);
	            weplaced[ii] = true;
	        }
	    }
	    return weplaced;
	}
	
	
	public static void unplaceHorizontally(char[][] arr, int i, int j, boolean[] weplaced){
	    for(int jj = 0 ; jj < weplaced.length ; jj++ ){
	        if( weplaced[jj] ){
	            arr[i][j + jj] = '-';
	        }
	    }
	}
	
	public static void unplaceVertically(char[][] arr, int i, int j, boolean[] weplaced){
	    for(int ii = 0 ; ii < weplaced.length ; ii++ ){
	        if( weplaced[ii] ){
	            arr[i + ii][j] = '-';
	        }
	    }
	}

	
	public static void print(char[][] arr){
		for(int i = 0 ; i < arr.length; i++){
			for(int j = 0 ; j < arr.length; j++){
				System.out.print(arr[i][j]);
			}
                  System.out.println();
		}
		
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		char[][] arr = new char[10][10];
		for(int i = 0 ; i < arr.length; i++){
			String str = scn.next();
			arr[i] = str.toCharArray();
		}
		int n = scn.nextInt();
		String[] words = new String[n];
		for(int i = 0 ; i  < words.length; i++){
			words[i] = scn.next();
		}
        scn.close();
        solution(arr, words, 0);
	}
}
