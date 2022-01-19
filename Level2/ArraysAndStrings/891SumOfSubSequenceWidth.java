class Solution {
    public int sumSubseqWidths(int[] nums) {
        Arrays.sort(nums);
        
        int mod = (int)1e9 + 7;
        
        int n = nums.length;
        long[] power = new long[n];
        
        long sum = 0;
        power[0] = 1;
        for(int i = 1 ; i < n ; i++ ){
            power[i] = (2 * power[i - 1] ) % mod;
        }
        
        for(int i = 0 ; i < n ; i++ ){
            sum += ( nums[i] * power[i] - power[n - 1 - i] *nums[i] );
            sum = sum % mod;
        }
        
        
        return (int) sum % mod;
    }
}