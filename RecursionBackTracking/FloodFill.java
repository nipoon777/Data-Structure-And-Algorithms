package RecursionBackTracking;

import java.util.*;

public class FloodFill {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();

        int[][] maze = new int[n][m];

        for(int i = 0 ; i < maze.length ; i++){
            for(int j = 0 ; j < maze[0].length ; j++){
                maze[i][j] = scn.nextInt();
            }
        }
        boolean[][] visited = new boolean[n][m];
        
        floodFill(maze,0, 0,"", visited);

        scn.close();
    }

    public static void floodFill(int[][] maze, int r, int c, String psf, boolean[][] visited){

        if( r < 0 || c < 0 || r == maze.length || c == maze[0].length 
        || maze[r][c] == 1 || visited[r][c]){
            return;
        }

        if(r == (maze.length -1) && c == (maze[0].length - 1)){
            System.out.println(psf);
        }

        visited[r][c] = true;
        floodFill(maze, r - 1, c, psf + "t", visited);
        floodFill(maze, r, c - 1, psf + "l", visited);
        floodFill(maze, r + 1, c, psf + "d", visited);
        floodFill(maze, r, c + 1, psf + "r", visited);
        visited[r][c] = false;


        

    }
    
}
