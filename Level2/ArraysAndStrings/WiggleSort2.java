public class Solution {
    public void wiggleSort(int[] nums) {
        int[] duplicate = new int[nums.length];
        int n = nums.length;
        
        for(int i = 0 ; i < nums.length ; i++ ){
            duplicate[i] = nums[i];
        }
        
        Arrays.sort(duplicate);
        
        int i = 1;
        int j = n - 1;
        
        while( i < n ){
            nums[i] = duplicate[j];
            i += 2;
            j -= 1;
        }
        i = 0;
        while( i < n ){
            nums[i] = duplicate[j];
            j -= 1;
            i += 2;
        }
        
    }
}class WiggleSort2 {
    
}
