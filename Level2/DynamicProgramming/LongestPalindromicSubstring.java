class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        String res = "";
        boolean[][] dp = new boolean[n][n];
        
        for(int gap = 0 ; gap < n ; gap++ ){
            for(int i = 0, j = gap ; j < n ; i++, j++ ){
                if( gap == 0 ){
                    dp[i][j] = true;
                }else if( gap == 1 ){
                    if( s.charAt(i) == s.charAt(j) ){
                        dp[i][j] = true;
                    }
                }else{
                    if( s.charAt(i) == s.charAt(j) && dp[i+1][j-1] ){
                        dp[i][j] = true;
                    }
                }
                if( dp[i][j] ){
                    res = s.substring(i, j + 1);
                }
            }
            
        }
        
        return res;
    }
}