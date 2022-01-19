class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (val1, val2) -> Integer.compare(val1[0], val2[0]));
        
        ArrayList<int[]> list = new ArrayList<>();
        
        int lsp = intervals[0][0];
        int lep = intervals[0][1];
        
        for(int i = 1 ; i < intervals.length ; i++ ){
            int sp = intervals[i][0];
            int ep = intervals[i][1];
            
            if( lep < sp ){
                //New Interval is found
                int[] subList = {lsp, lep};
                
                list.add(subList);
                lsp = sp;
                lep = ep;
                
            }else{
                //Update the Ending pointing depending whether there is a partial
                // or full overlapping
                if( lep < ep ){
                    lep = ep;
                }
            }
        }
        
        int[] subList = {lsp, lep};
                
        list.add(subList);
        
        return list.toArray( new int[list.size()][] );
        
    }
}