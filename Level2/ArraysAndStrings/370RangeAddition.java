class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] res = new int[length];
        
        
        // 1. Query ke hisab se arr[startIdx] = val & arr[endIDx + 1] = - val fill kardo
        
        
        for(int i = 0 ; i < updates.length ; i++ ){
            int strtIdx = updates[i][0];
            int endIdx = updates[i][1];
            int val = updates[i][2];
            
            res[strtIdx] += val;
            if(endIdx + 1 < length ) res[endIdx + 1] += -val;
        }
        
        // 2. Now calculate the prefix sum kyuki prefix sum se jo -val hai vo nullify ho jata hai
        
        for(int i = 1 ; i < length ; i++ ){
            res[i] = res[i] + res[i - 1];
        }
        
        return res;
        
    }
}