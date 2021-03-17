package Level2.RecursionAndBackTrack;

import java.util.*;

public class NQueens {

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    boolean[][] board = new boolean[n][n];
    //write your code here
    
    boolean[] cols = new boolean[n];
    boolean[] normalD = new boolean[ 2* n - 1 ];
    boolean[] revD = new boolean[ 2 * n - 1];
    
    solve(board, cols, normalD, revD, 0, "");
    
  }
  
  public static void solve( boolean[][] board, boolean[] cols, boolean[] normalD, boolean[] revD, int row, String asf ){
      
      if( row == board.length ){
          System.out.println(asf + ".");
          return;
      }
      
      for(int col = 0 ; col < board[0].length ; col++ ){
          if(cols[col] == false && normalD[row + col] == false && revD[row - col + board.length - 1] == false){
              cols[col] = true;
              normalD[row + col ] = true;
              revD[row - col + board.length - 1] = true;
              solve(board, cols, normalD, revD, row + 1, asf + row + "-" + col + ", ");
              cols[col] = false;
              normalD[row + col ] = false;
              revD[row - col + board.length - 1] = false;
              
          }
      }
  }

}