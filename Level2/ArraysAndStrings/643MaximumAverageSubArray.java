class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double avg = Integer.MIN_VALUE;
        int leftPtr = 0;
        
        int rightPtr = 0;
        double cSum = 0;
        while( rightPtr < k ){
            cSum += nums[rightPtr];
            rightPtr++;
        }
        int n = nums.length;
        avg = Math.max(avg, cSum);
        while( rightPtr < n)
        {
            cSum -= nums[leftPtr];
            cSum += nums[rightPtr];
            avg = Math.max(cSum, avg);
            leftPtr++;
            rightPtr++;
        }
        
        return avg / k;
        
    }
}