import java.util.*;

public class Main {
    
    public static int solutionForOne(String str ){
        HashMap <Character, Integer> hmap = new HashMap <>();
        
        int i = -1;
        int j = -1;
        
        int ans = 0;
        while ( true ){
            
            boolean flag1 = false;
            boolean flag2 = false;
            
            while( i < str.length()  - 1 ){
                i++;
                char ch = str.charAt(i);
                flag1 = true;
                hmap.put(ch, hmap.getOrDefault(ch, 0 ) + 1 );
                
                if( hmap.size() == 2 ){
                    removeChFromMap(hmap, ch);
                    i--;
                    break;
                }
            }
            
            while( j < i ){
                
                flag2 = true;
                if( hmap.size() == 1 ){
                    ans += i - j;
                }
                
                j++;
                char ch = str.charAt(j);
                
                removeChFromMap(hmap, ch);
                
                if( hmap.size() < 1 ){
                    break;
                }
                
            }
            
            if( !flag1 && !flag2 ){
                break;
            }
            
        }
        
        
        return ans;
        
    }

	public static int solution(String str, int k){
		// write your code here
        
        if( k == 1 ){
            return solutionForOne(str);
        }
        
        
        
        HashMap <Character, Integer > mapb = new HashMap <>();
        HashMap <Character, Integer > maps = new HashMap <>();
        
        int ib = -1;
        int is = -1;
        
        int j = -1;
        
        int ans = 0;
        
        while( true ){
            boolean flag1 = false;
            boolean flag2 = false;
            boolean flag3 = false;
            
            
            while( ib < str.length() - 1){
                ib++;
                char ch = str.charAt(ib);
                mapb.put(ch, mapb.getOrDefault(ch, 0) + 1);
                flag1 = true;
                if( mapb.size() == k + 1 ){
                    removeChFromMap(mapb, ch);
                    ib--;
                    break;
                }
            }
            
            while ( is < ib ){
                is++;
                char ch = str.charAt(is);
                
                maps.put(ch, maps.getOrDefault(ch, 0) + 1);
                
                
                flag2 = true;
                if( maps.size() == k ){
                    removeChFromMap(maps, ch);
                    is--;
                    break;
                }
            }
            
            while( j < is ){
                
                ans += ib - is;
                
                j++;
                
                char ch = str.charAt(j);
                removeChFromMap(mapb, ch);
                removeChFromMap(maps, ch);
                
                if( mapb.size() < k || maps.size() < k - 1 ){
                    break;
                }
            }
            
            if( !flag1 && !flag2 && !flag3 ){
                break;
            }
        }
        
        
        
        
		return ans;
	}
	
	public static void removeChFromMap (HashMap <Character, Integer> hmap , char ch){
	    if( hmap.get(ch) == 1 ){
	        hmap.remove(ch);
	    }else{
	        hmap.put(ch, hmap.get(ch) - 1);
	    }
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int k = scn.nextInt();
		System.out.println(solution(str,k));
	}

}
