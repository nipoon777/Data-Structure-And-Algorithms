class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;
        
        for(int i = 0 ; i < gas.length ; i++ ){
            totalGas += gas[i];
            totalCost += cost[i];
        }
        
        if( totalGas < totalCost ){
            return -1;
        }
        
        int indx = 0;
        int preSum = 0;
        int min = Integer.MAX_VALUE;
        
        for(int i = 0 ; i < gas.length ; i++ ){
            preSum += gas[i] - cost[i];
            
            if( min > preSum ){
                min = preSum;
                indx = i;
            }
        }
        
        return (indx + 1) % gas.length;
        
    }
}