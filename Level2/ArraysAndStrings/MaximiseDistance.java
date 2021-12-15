class Solution {
    public int maxDistToClosest(int[] seats) {
        int i = 0;
        int distance = 0;
        int zeros = 0;
        while( i < seats.length && seats[i] == 0 ) i++;
        
        distance = i;
        i++;
        
        while( i < seats.length ){
            if( seats[i] == 1 ){
                int count = (zeros + 1) / 2;
                distance = Math.max(distance, count);
                zeros = 0;
            }else{
                zeros++;
            }
            i++;
        }
        distance = Math.max(distance, zeros);
        
        
        return distance;
        
    }
}