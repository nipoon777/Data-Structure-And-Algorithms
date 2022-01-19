class Solution {
    public int minOperations(int n) {
        int movesSum = 0;
        int val = 1;
        for(int i = 1 ; i <= n/2 ; i++ ){
            movesSum += Math.abs(n - val);
            val += 2;
        }
        return movesSum;
    }
}