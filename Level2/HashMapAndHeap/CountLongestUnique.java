import java.util.*;

public class Main {

	public static int solution(String str) {
		// write your code here
		
		HashMap < Character, Integer > hmap = new HashMap<>();
		
		int i = -1;
		int j = -1;
		
		int count = 0;
		
		while( true ){
		    boolean flag1 = false;
		    boolean flag2 = false;
		    
		    while ( i < str.length() - 1 ){
		        i++;
		        flag1 = true;
		        char ch = str.charAt(i);
		        
		        hmap.put( ch , hmap.getOrDefault(ch, 0) + 1);
		        
		        if( hmap.get(ch) == 2 ){
		            break;
		        }else{
		            count += i - j;
		        }
		    }
		    
		    
		    while( j < i ){
		        j++;
		        
		        char ch = str.charAt(j);
		        flag2 = true;
		        hmap.put(ch, hmap.get(ch) - 1);
		        
		        if( hmap.get(ch) == 1){
		            count += i - j;
		            break;
		        }
		    }
		    
		    if( !flag1 && !flag2  ){
		        break;
		    }
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(solution(str));
	}

}
