class Solution {
    public int nextGreaterElement(int n) {
        String str = n + "";
        
        String nge = nextGreaterElement(str);
        
        long res = Long.parseLong(nge);
        if( res > Integer.MAX_VALUE ) return -1;
        return (int)res;
    }
    
    public String nextGreaterElement(String str){
        if( str.length() == 1 ) return "-1";
        
        char[] nums = str.toCharArray();
        //Get the fist Minimum number to find the replace
        int dipIdx = getDipIdx(nums);
        
        if( dipIdx == -1)return "-1";
        
        int ceilIdx = getCeilIdx(nums, dipIdx);
        swap(nums, dipIdx, ceilIdx);
        reverse(nums,dipIdx + 1, nums.length - 1);
        
        return String.valueOf(nums);
        
    }
    
    public void swap(char[] nums, int i, int j ){
        char temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        return;
    }
    public void reverse(char[] nums, int startIdx, int endIdx){
        while( startIdx < endIdx ){
            swap(nums, startIdx, endIdx );
            startIdx++;
            endIdx--;
        }
    }
    
    public int getCeilIdx(char[] nums, int dipIdx){
        
        for(int i = nums.length - 1; i > dipIdx ; i--){
            if( nums[i] > nums[dipIdx] ){
                return i;
            }
        }
        return -1;
    }
    public int getDipIdx(char[] nums){
        int idx = nums.length - 2;
        while( idx >= 0 && nums[idx] >= nums[idx + 1])
            idx--;
        return idx;
    }
}