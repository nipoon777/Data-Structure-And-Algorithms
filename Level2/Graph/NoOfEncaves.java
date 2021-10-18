class Solution {
    public int numEnclaves(int[][] grid) {
        
        int count = 0;
        boolean[] connectedToboundary;
        int[] sizeOfIsland;
        for(int r = 0 ; r < grid.length ; r++ ){
            for(int c = 0 ; c < grid[0].length ; c++ ){
                if( grid[r][c] == 1 ){
                    connectedToboundary = new boolean[]{false};
                    sizeOfIsland = new int[]{0};
                    helper(grid, r, c, connectedToboundary, sizeOfIsland);
                    if( !connectedToboundary[0]){
                        count += sizeOfIsland[0];
                    }
                }
            }
        }
        
        return count;
    }
    
    
    static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public void helper(int[][] grid, int r, int c, boolean[] connectedToboundary, int[] sizeOfIsland ){
        if( r == 0 || c == 0 || r == grid.length -1  || c == grid[0].length - 1 ){
            connectedToboundary[0] = true;
        }
        
        grid[r][c] = 2;
        sizeOfIsland[0]++;
        
        for(int i = 0 ; i < dir.length ; i++ ){
            int rowdash = r + dir[i][0];
            int coldash = c + dir[i][1];
            
            if( rowdash < 0 || coldash < 0 || rowdash >= grid.length || coldash >= grid[0].length || grid[rowdash][coldash] != 1){
                continue;
            }
            
            helper(grid, rowdash, coldash, connectedToboundary, sizeOfIsland);
            
        }
        
        
    }
}