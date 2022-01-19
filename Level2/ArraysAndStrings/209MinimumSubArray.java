class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int leftPtr = 0;
        int res = Integer.MAX_VALUE;
        int sum = 0;
        
        for(int rightPtr = 0 ; rightPtr < nums.length ; rightPtr++ ){
            if( nums[rightPtr] >= target ){
                return 1;
            }else{
                sum += nums[rightPtr];
                
                while( sum >= target ){
                    res = Math.min( res, rightPtr - leftPtr + 1 );
                    sum -= nums[leftPtr];
                    leftPtr++;
                }
            }
        }
        
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}