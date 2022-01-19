class Solution {
    public boolean isRobotBounded(String instructions) {
        
        int[][] directions = new int[][]{ {0, 1}, {1, 0}, {0, -1}, {-1, 0} };//North, East, south, west;
        
        int idx = 0;
        int x = 0;
        int y = 0;
        for( char ch : instructions.toCharArray() ){
            if( ch == 'L'){
                idx = ( idx + 3) % 4;
            }else if( ch == 'R' ){
                idx = ( idx + 1) % 4;
            }else{
                x += directions[idx][0];
                y += directions[idx][1]; 
            }
        }
        
        return ( x == 0 && y == 0) ||( idx != 0 );
    }
}