class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> hmap = new HashMap<>();
        
        int i = -1;
        int j = -1;
        int ans = 0;
        
        while( true ){
            boolean f1 = false;
            boolean f2 = false;
            
            //Acquire
            while( i < s.length() - 1 ){
                f1 = true;
                i++;
                char ch = s.charAt(i);
                hmap.put( ch, hmap.getOrDefault(ch, 0 ) + 1);
                
                if( hmap.get(ch) == 2){
                    break;
                }else{
                    int len = i - j;
                    if( len > ans ){
                        ans = len;
                    }
                }
            }
            
            //Release
            while( j < i ){
                f2 = true;
                j++;
                char ch = s.charAt(j);
                hmap.put( ch, hmap.get(ch) - 1);
                if( hmap.get(ch) == 1){
                    break;
                }
                    
            }
            
            if( f1 == false && f2 == false ){
                break;
            }
        }
        
        return ans;
    }
}