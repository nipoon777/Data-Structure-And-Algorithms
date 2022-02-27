import java.util.*;

public class Main {

	public static int solution(String str, int k){
		// write your code here
		int ans = 0;
		
		int i = -1;
		int j = -1;
		
		HashMap < Character, Integer > hmap = new HashMap <>();
		
		while( true ){
		    
		    boolean flag1 = false;
		    boolean flag2 = false;
		    
		    while ( i < str.length() - 1 ){
		        i++;
		        
		        flag1 = true;
		        char ch = str.charAt(i);
		        
		        hmap.put(ch, hmap.getOrDefault(ch, 0) + 1 );
		        
		        if( hmap.size() < k ){
		            continue;
		        }else if( hmap.size() == k ){
		            ans = Math.max(ans, i - j);
		        }else{
		            break;
		        }
		    }
		    
		    while( j < i ){
		        j++;
		        
		        flag2 = true;
		        char ch = str.charAt(j);
		        
		        if( hmap.get(ch) == 1){
		            hmap.remove(ch);
		        }else{
		            hmap.put(ch, hmap.get(ch) - 1);
		        }
		        
		        if( hmap.size() > k ){
		            continue;
		        }else if( hmap.size() == k ){
		            ans = Math.max(ans, i - j);
		            break;
		        }
		    }
		    if( !flag1 && !flag2 ){
		        break;
		    }
		}

		return ans;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int k = scn.nextInt();
		System.out.println(solution(str,k));
	}

}
