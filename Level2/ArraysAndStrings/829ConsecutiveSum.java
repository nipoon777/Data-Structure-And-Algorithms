class Solution {
    public int consecutiveNumbersSum(int n) {
        // 1. Each length has only one solution
        // 2. For Example N = 15 
        // 3. k = 1 = 15
            // k = 2 = 7 + 8
            // k = 3 = 4 + 5 + 6
        // We have to find the upper limit to the k 
        // Using the Summation formula k * ( k- 1) < N
        // Now once we know till the point we have to proceed
        // The next step is to know if we can form a solution
        // While Solving we found that first element is X which is an integer
        // So if we can get an integral X we can form a consecutive sequence
        int count = 0;
        
        for(int k = 1 ; k * ( k - 1) < 2 * n ; k++ ){
            int numerator = ( n - ((k *( k - 1) )/ 2) );
            if( numerator % k == 0){
                count++;
            }
        }
        return count;
        
    }
}