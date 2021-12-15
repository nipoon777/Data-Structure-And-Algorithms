class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int[] res = new int[nums.length];
        int n = nums.length;
        int[] leftProduct = new int[nums.length];
        int[] rightProduct = new int[nums.length];
        
        leftProduct[0] = nums[0];
        rightProduct[n - 1] = nums[n - 1];
        
        for(int i = 1; i < n ; i++ ){
            leftProduct[i] = leftProduct[i - 1] * nums[i];
            rightProduct[n - i - 1] = rightProduct[n - i] * nums[n - i - 1];
        }
        
        res[0] = rightProduct[1];
        res[n - 1] = leftProduct[n - 2];
        
        for(int i = 1 ; i < n - 1 ; i++ ){
            res[i] = leftProduct[i - 1] * rightProduct[i + 1];
        }
        
        return res;
        
    }
}