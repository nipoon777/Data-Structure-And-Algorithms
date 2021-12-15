class Solution {
    public int maxChunksToSorted(int[] arr) {
        int chunks = 0;
        int maxImpact = 0;
        for(int i = 0 ; i < arr.length ; i++ ){
            if( arr[i] > maxImpact ) {
                maxImpact = arr[i];
            }
            if( i == maxImpact ) chunks++;
        }
        return chunks;
    }
}