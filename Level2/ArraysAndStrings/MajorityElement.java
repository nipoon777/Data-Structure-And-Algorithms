class Solution {
    public int majorityElement(int[] nums) {
        int count = 1;
        int val = nums[0];
        
        for(int i = 1 ; i < nums.length ; i++ ){
            if( nums[i] == val ){
                count++;
            }else if( count > 0 ){
                count--;
            }else{
                val = nums[i];
                count = 1;
            }
        }
        
        return val;
    }
}