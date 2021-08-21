import java.util.*;

public class WarMines{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int nr = scn.nextInt();
        int nc = scn.nextInt();

        int[][] mine = new int[nr][nc];

        for(int i = 0 ; i < mine.length ; i++ ){
            for(int j = 0 ; j < mine[0].length ; j++ ){
                mine[i][j] = scn.nextInt();
            }
        }

        System.out.println( solve(mine) - 1);
    }

    public static int solve(int[][] mine){
        preprocess(mine);
        int len = Integer.MAX_VALUE;
        for(int i = 0 ; i < mine.length ; i++ ){
            int res = solution(mine,i, 0);
            len = res < len ? res : len;
        }
        return len;
    }
    public static int solution(int[][] mine, int r, int c){
        if( r < 0 || r >= mine.length || c < 0 || c >= mine[0].length || mine[r][c] != 1){
            return Integer.MAX_VALUE;
        }
        if( c == mine[0].length - 1 ){
            return 1;
        }
        mine[r][c] = 3; //Visited;
        int len = Integer.MAX_VALUE;
        len = Math.min(len, solution(mine, r + 1, c));
        len = Math.min(len, solution(mine, r, c + 1));
        len = Math.min(len, solution(mine, r - 1, c));
        len = Math.min(len, solution(mine, r, c - 1));
        mine[r][c] = 1;
        len = (len == Integer.MAX_VALUE) ? len : len + 1;
        return len;
    }
    public static void preprocess(int[][] mine){
        for(int i = 0 ; i < mine.length ; i++ ){
            for(int j = 0 ; j < mine[0].length ; j++ ){
                if( mine[i][j] == 0){
                    if( i - 1 >= 0 && mine[i-1][j] != 0){
                        mine[i - 1][j] = 2;
                    }
                    if( j + 1 < mine[0].length && mine[i][j + 1] != 0){
                        mine[i][j + 1] = 2;
                    }
                    if( i + 1 < mine.length && mine[i + 1][j] != 0){
                        mine[i + 1][j] = 2;
                    }
                    if( j - 1 >= 0 && mine[i][j - 1] != 0){
                        mine[i][j - 1] = 2;
                    }
                }
            }
        }
    }
}