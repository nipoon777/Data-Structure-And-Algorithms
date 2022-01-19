class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int len = 0;
        
        int[] roadSize = new int[1001]; // Given as maximum to can be 1000;
        
        //number of rows is number of rides;
        
        int rides = trips.length;
        
        for(int i = 0 ; i < rides ; i++ ){
            int passengers = trips[i][0];
            int startPoint = trips[i][1];
            int endPoint = trips[i][2];
            
            roadSize[startPoint] += passengers;
            roadSize[endPoint] -= passengers;
            
            if( endPoint > len ){
                len = endPoint;
            }
        }
        
        //Now lets calculate the prefix sum and check
        int preSum = 0;
        for(int i = 0 ; i <= len ; i++ ){
            preSum += roadSize[i];
            roadSize[i] = preSum;
            if( roadSize[i] > capacity ){
                return false;
            }
        }
        return true;
        
    }
}