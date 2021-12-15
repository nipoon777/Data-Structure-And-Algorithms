class Solution {
    public int firstMissingPositive(int[] nums) {
        // Check if one is present
        boolean one = false;
        
        int n = nums.length;
        // Mark the label 1 for elements out of range < 1 || > length
        for(int i = 0 ; i < n ; i++ ){
            if( nums[i] == 1) one = true;
            if( nums[i] <= 0 || nums[i] > n) nums[i] = 1;
        }
        
        if( !one ) return 1;
        // Mark all the elements by negative of the original number
        for(int i = 0 ; i < n ; i++ ){
            int val = Math.abs(nums[i]);
            nums[val - 1] = - Math.abs(nums[val - 1]);
        }
        //Check for the first missing positive
        for( int i = 0 ; i < n ; i++ ){
            if( nums[i] > 0 ) return i + 1;
        }
        
        return n + 1;
        
    }
}