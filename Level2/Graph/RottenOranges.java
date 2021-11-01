class Solution {
    public int orangesRotting(int[][] grid) {
        Queue <Pair> mq = new ArrayDeque<>();
        int freshOranges = 0;
        
        for(int r = 0 ; r < grid.length ; r++ ){
            for(int c = 0 ; c < grid[0].length ; c++ ){
                if( grid[r][c] == 2){
                    mq.add( new Pair(r, c) );
                }else if( grid[r][c] == 1){
                    freshOranges++;
                }
            }
        }
        
        
        int[][] dir = {{-1, 0}, {0, 1}, {1, 0} , {0, -1}};
        int level = 0;
        while( mq.size() > 0 ){
            int levelSize = mq.size();
            while( levelSize-- > 0 ){
                Pair pair = mq.remove();
                for(int r = 0  ; r < dir.length ; r++ ){
                    int rowdash = pair.x + dir[r][0];
                    int coldash = pair.y + dir[r][1];
                    
                    if( rowdash < 0 || coldash < 0 || rowdash >= grid.length || coldash >= grid[0].length || grid[rowdash][coldash] != 1){
                        continue;
                    }
                    
                    freshOranges--;
                    grid[rowdash][coldash] = 2;
                    mq.add(new Pair(rowdash, coldash));
                }
            }
            if( mq.size() > 0 ){
                level++;
            }
        }
        if( freshOranges != 0 ){
            return -1;
        }else{
            return level;
        }
        
    }
    
    class Pair{
        int x;
        int y;
        
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}