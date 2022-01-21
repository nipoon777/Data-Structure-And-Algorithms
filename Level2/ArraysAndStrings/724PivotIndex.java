class Solution {
    public int pivotIndex(int[] nums) {
        int total_Sum = 0;
        
        for(int val : nums ){
            total_Sum += val;
        }
        
        int leftSum = 0;
        
        for(int i = 0 ; i < nums.length ; i++ ){
            if( total_Sum - leftSum - nums[i] == leftSum ){
                return i;
            }
            leftSum += nums[i];
        }
        
        return -1;
        
    }
}