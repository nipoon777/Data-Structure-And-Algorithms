class Solution {
    public boolean isPalindrome(int x) {
        if( x == 0 ) return true;
        if( x < 0 || x % 10 == 0 ) return false;
        
        int reverseInt = 0;
        
        while( x > reverseInt ){
            int digit = x % 10;
            x /= 10;
            
            reverseInt = reverseInt * 10 + digit;
        }
        
        if(x == reverseInt || x == reverseInt / 10){
            return true;
        }else{
            return false;
        }
        
    }
}