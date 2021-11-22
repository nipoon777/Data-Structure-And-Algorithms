class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int val1 = nums[0];
        int val2 = Integer.MIN_VALUE;
        int count1 = 1;
        int count2 = 0;
        
        for(int i = 1 ; i < nums.length ; i++ ){
            if( nums[i] == val1 ){
                count1++;
            }else if( nums[i] == val2 ){
                count2++;
            }else{
                if( count1 == 0 ){
                    val1 = nums[i];
                    count1++;
                }else if( count2 == 0 ){
                    val2 = nums[i];
                    count2++;
                }else{
                    count1--;
                    count2--;
                }
            }
        }
        
        int countVal1 = 0, countVal2 = 0;
        for(int val : nums ){
            if( val == val1) countVal1++;
            if( val == val2) countVal2++;
        }
        List<Integer> res = new ArrayList<>();
        if( countVal1 > (nums.length)/3 ) res.add(val1);
        if( countVal2 > (nums.length)/3 ) res.add(val2);
        
        return res;
        
    }
}