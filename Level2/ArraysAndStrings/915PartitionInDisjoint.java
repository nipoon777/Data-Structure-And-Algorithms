class Solution {
    public int partitionDisjoint(int[] nums) {
        
        int maxInRun = nums[0];
        int maxInPartition = nums[0];
        
        int ans = 0;
        
        for(int i = 1 ; i < nums.length ; i++ ){
            if( nums[i] > maxInRun ){
                maxInRun = nums[i];
            }
            
            if( nums[i] < maxInPartition ){
                ans = i;
                maxInPartition = maxInRun;
            }
        }
        
        return ans + 1;

        //Method 2;
        int n = arr.length;
        int[] rightMin = new int[n];
        
        rightMin[n - 1] = arr[n - 1];
        
        for(int i = n - 2 ; i >= 0 ; i-- ){
            rightMin[i] = Math.min(arr[i], rightMin[i+1] );
        }
        int leftMax = Integer.MIN_VALUE;
        
        for(int i = 0 ; i < n - 1 ; i++ ){
            leftMax = Math.max(leftMax, arr[i] );
            if( leftMax < rightMin[i + 1] ){
                return i + 1;
            }
        }
        return -1;
    }
}