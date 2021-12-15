class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        
        int overallCount = 0;
        int prevCount = 0;
        
        int start = 0;
        int curr = 0;
        
        while( curr < nums.length ){
            // Three possible cases possible hai 
            // In range vala solution
            if( nums[curr] >= left && nums[curr] <= right ){
                prevCount = curr - start + 1;
                overallCount += prevCount;
                
            }else if( nums[curr] < left ){// Range is chota vala element
                overallCount += prevCount;
            }else{ // Range ke bahar vala element
                start = curr + 1;
                prevCount = 0;
            }
            curr++;
        }
        
        return overallCount;
    }
}