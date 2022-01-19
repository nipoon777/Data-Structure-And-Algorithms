class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        if( intervals.length == 0) return true;
        
        Arrays.sort(intervals, (val1, val2) -> Integer.compare(val1[0], val2[0]));
        
        int lsp = intervals[0][0];
        int lep = intervals[0][1];
        
        for(int i = 1 ;i < intervals.length ; i++ ){
            int sp = intervals[i][0];
            int ep = intervals[i][1];
            
            if( lep <= sp ){
                lep = ep;
            }else{
                return false;
            }
        
        }
        return true;
        
    }
}