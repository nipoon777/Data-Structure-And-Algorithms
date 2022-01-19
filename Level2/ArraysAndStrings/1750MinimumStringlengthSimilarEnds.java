class Solution {
    public int minimumLength(String s) {
        char[] str = s.toCharArray();
        
        int left = 0;
        int right = str.length - 1;
        
        while( left < right && str[left] == str[right] ){
            char ch = str[left];
            
            while( left <= right && str[left] == ch ){
                left++;
            }
            while( left <= right && str[right] == ch){
                right--;
            }
        }
        
        return right - left + 1;
    }
}