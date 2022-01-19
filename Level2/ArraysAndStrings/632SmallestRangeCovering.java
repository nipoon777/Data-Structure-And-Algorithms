class Solution {
    private class Pair implements Comparable<Pair> {
        int val;
        int rowNum;
        int colNum;
        
        Pair( int val, int rowNum, int colNum ){
            this.val = val;
            this.rowNum = rowNum;
            this.colNum = colNum;
        }
        
        public int compareTo(Pair o){
            return this.val - o.val;
        }
    
    }
    public int[] smallestRange(List<List<Integer>> nums) {
        
        PriorityQueue <Pair> pq = new PriorityQueue<>();
        
        int max = Integer.MIN_VALUE;
        int sp = 0;// Min Value in range
        int ep = 0; // Max Value in range
        int length = Integer.MAX_VALUE; // Difference between sp and ep;
        
        // First Add the first K elements of the list in priority Queue;
        
        for(int i = 0 ; i < nums.size() ; i++ ){
            int val = nums.get(i).get(0);
            pq.add( new Pair(val, i, 0));
            max = Math.max(max, val);
        }
        
        
        while( true ){
            //remove the minimum element from the PriorityQueue
            
            Pair rem = pq.remove();
            int cmin = rem.val;
            int cmax = max;
            if( cmax - cmin < length ){
                length = cmax - cmin;
                sp = cmin;
                ep = cmax;
            }
            //Add the next element of the array with minimum value
            
            if( rem.colNum + 1 < nums.get(rem.rowNum).size() ){
                int val = nums.get(rem.rowNum).get(rem.colNum + 1);
                max = Math.max( val, max);
                pq.add( new Pair(val, rem.rowNum, rem.colNum + 1));
            }else{
                break;
            }
        }
        
        int[] res = { sp, ep } ;
        return res;
    }
}