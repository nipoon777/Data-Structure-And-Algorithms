class Solution {
    public class Pair{
        int row;
        int col;
        int level;
        Pair(int row, int col, int level ){
            this.row = row;
            this.col = col;
            this.level = level;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int res[][] = new int[mat.length][mat[0].length];
        
        Queue <Pair> mq = new ArrayDeque<>();
        // Add All the Zero Coordinated to the Queue
        for(int r = 0 ; r < mat.length ; r++ ){
            for( int c = 0 ; c < mat[0].length ; c++ ){
                if( mat[r][c] == 0 ){
                    mq.add( new Pair(r, c, 0));
                }
            }
        }
        
        int[][] dir = { {-1, 0}, {0, 1}, { 1, 0}, { 0, -1}};
        while( mq.size() > 0 ){
            Pair rp = mq.remove();
            res[rp.row][rp.col] = rp.level;
            for(int i = 0 ; i < dir.length ; i++ ){
                int rowdash = rp.row + dir[i][0];
                int coldash = rp.col + dir[i][1];
                
                if( rowdash < 0 || coldash < 0 || rowdash >= mat.length || coldash >= mat[0].length || mat[rowdash][coldash] != 1 ){
                    continue;
                }
                
                mq.add( new Pair(rowdash, coldash, rp.level + 1));
                mat[rowdash][coldash] = 0;
            }
            
        }
        
        return res;
    }
}