class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List <Integer> res = new ArrayList<>();
        
        for(int i = 0 ; i < nums.length ; i++ ){
            int indx = Math.abs(nums[i]) - 1;
            if( nums[indx] < 0 ){
                res.add(indx + 1);
            }else{
                nums[indx] = - nums[indx];
            }
        }
        
        
        return res;
        
    }
}