class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        int[] start = new int[ intervals.length ];
        int[] end = new int[ intervals.length ];
        
        for(int i = 0 ;i < intervals.length ; i++ ){
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        
        int maxRooms = 0;
        int stTime = 0;
        int endTime = 0;
        int cRoom = 0;
        
        while( stTime < n ){
            if( start[stTime] < end[endTime] ){
                cRoom++;
                stTime++;
            }else{
                cRoom--;
                endTime++;
            }
            maxRooms = Math.max(maxRooms, cRoom);
        }
        return maxRooms;
    }
}