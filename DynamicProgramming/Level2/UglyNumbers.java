// { Driver Code Starts
    import java.io.*;
    import java.util.*;
    
    class GFG {
        public static void main(String[] args) throws IOException {
            BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
            int t =
                Integer.parseInt(br.readLine().trim()); // Inputting the testcases
            while (t-- > 0) {
                int n = Integer.parseInt(br.readLine().trim());
    
                System.out.println(new Solution().getNthUglyNo(n));
            }
        }
    }// } Driver Code Ends
    
    
    class Solution {
        /* Function to get the nth ugly number*/
        long getNthUglyNo(int n) {
            // code here
            long [] dp = new long[n + 1];
            
            dp[1] = 1;
            int p2 = 1;
            int p3 = 1;
            int p5 = 1;
            
            for(int i = 2 ; i <= n ; i++ ){
                long val1 = dp[p2] * 2;
                long val2 = dp[p3] * 3;
                long val3 = dp[p5] * 5;
                long val = Math.min(val1, Math.min(val2, val3) );
                dp[i] = val;
                if( val == val1 ){
                    p2++;
                }
                if( val == val2 ){
                    p3++;
                }
                if( val == val3 ){
                    p5++;
                }
            }
            
            return dp[n];
        }
    }