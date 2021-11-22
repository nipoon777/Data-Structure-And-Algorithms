class Solution {
    public int[] sortedSquares(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        int [] res = new int[nums.length];
        for(int k = nums.length - 1; k >= 0 ; k-- ){
            int val1 = nums[i] * nums[i];
            int val2 = nums[j] * nums[j];
            
            if( val1 > val2 ){
                res[k] = val1;
                i++;
            }else{
                res[k] = val2;
                j--;
            }
        }
        return res;
    }
}