class Solution {
    public int kadanes(int[] arr){
        int csum = 0;
        int osum = Integer.MIN_VALUE;
        for(int val : arr){
            if( csum < 0 ){
                csum = val;
            }else{
                csum += val;
            }
            osum = Math.max(csum, osum);
        }
        return osum;
    }
    public int kConcatenationMaxSum(int[] arr, int k) {
        int tSum = 0;
        
        for(int val : arr){
            tSum += val;
        }
        if( k < 2 ){
            return kadanes(arr) > 0 ? kadanes(arr) : 0;
        }else{
            int[] narr = new int[arr.length * 2];
            for(int i = 0 ; i < narr.length ; i++ ){
               narr[i] = arr[i % arr.length];
            }
            if( tSum >= 0 ){  
               tSum = (k -2) * tSum + kadanes(narr); 
            }else{
               tSum = kadanes(narr); 
            }            
        }
            
        return tSum > 0 ? tSum : 0;   
    }
}