class Solution {
    public int maxSubArray(int[] nums) {
        int cSum = 0;
        int oSum = Integer.MIN_VALUE;
        
        for(int i = 0 ; i < nums.length ; i++ ){
            if( cSum < 0 ){
                cSum = nums[i];
            }else{
                cSum += nums[i];
            }
            oSum = Math.max(cSum, oSum);
        }
        
        return oSum;
    }
}