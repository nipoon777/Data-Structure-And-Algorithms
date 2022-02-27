import java.util.*;

public class Main {

	public static int solution(String str) {
		// write your code here
		
		
		HashMap < Character, Integer > hmap = new HashMap <>();
		
		int res = 0;
		int i = -1;
		int j = -1;
		
		
		
		while( true ){
		    boolean flag1 = false;
		    boolean flag2 = false;
		    
		    while( i < str.length()- 1 ){
		        
		        i++;
		        char ch = str.charAt(i);
		        
		        if( hmap.containsKey(ch) ){
		            hmap.put(ch, hmap.get(ch) + 1 );
		            break;
		        }else{
		            hmap.put(ch, 1);
		        }
		        flag1 = true;
		    }
		    while( j < i ){
		        flag2 = true;
		        
		        j++;
		        
		        res = Math.max(res, i - j  + 1);
		        
		        char ch = str.charAt(j);
		        
		        if( ch == str.charAt(i) ){
		            hmap.put(ch, 1);
		            break;
		        }else{
		            hmap.remove(ch);
		        }
		        
		    }
		    
		    
		    if( flag1 == false && flag2 == false ){
		        break;
		    }
		}
		
	
		return res;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(solution(str));
	}

}
