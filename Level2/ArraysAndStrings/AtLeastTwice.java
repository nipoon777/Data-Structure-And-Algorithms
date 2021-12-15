class Solution {
    public int dominantIndex(int[] arr) {
        if( arr.length == 1 ) return 0;
        
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int idx = 0;
        
        for( int i = 0 ; i < arr.length ; i++ ){
            if( arr[i] > max1 ){
                max2 = max1;
                max1 = arr[i];
                idx = i;
            }else if( arr[i] > max2 ){
                max2 = arr[i];
            }
        }
        
        return max1 >= 2*max2  ? idx : -1; 
        
    }
}