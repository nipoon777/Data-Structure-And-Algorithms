package Level2.RecursionAndBackTrack;

import java.util.*;

public class SolveSudoku {
  public static void display(int[][] board){
    for(int i = 0; i < board.length; i++){
      for(int j = 0; j < board[0].length; j++){
        System.out.print(board[i][j] + " ");
      }
      System.out.println();
    }
  }

  public static void solveSudoku(int[][] board, int i, int j) {
    // write yopur code here
    if( i == board.length ){
        display(board);
        return;
    }
    
    int nexti = 0;
    int nextj = 0;
    
    if(j == board[0].length - 1){
        nexti = i + 1;
        nextj = 0;
    }else{
        nexti = i;
        nextj = j + 1;
    }
    
    if(board[i][j] != 0){
        solveSudoku(board, nexti, nextj);
    }else {
        for(int pos = 1 ; pos <= 9 ; pos++ ){
        
            if( isValidSolution(board, i, j, pos) ){
                board[i][j] = pos;
                solveSudoku(board, nexti, nextj);
                board[i][j] = 0;
            }
        }
        
    }
    
    
  }
  
  public static boolean isValidSolution(int[][] board, int x , int y , int val ){
      //Check in Row
      
      for(int j = 0 ; j < board[0].length ; j++ ){
          if(board[x][j] == val){
              return false;
          }
      }
      
      //Check in Column i will change
      
      for(int i = 0 ; i < board.length ; i++ ){
          if( board[i][y] == val){
              return false;
          }
      }
      
      //Check in SubMatrix 
      
      int subMatrixX = (x / 3) * 3;
      int subMatrixY = (y / 3) * 3;
      
      for(int i = 0 ; i < 3 ; i++ ){
          for(int j = 0 ; j < 3 ; j++){
              if( board[subMatrixX + i][subMatrixY + j] == val ){
                  return false;
              }
          }
      }
      
      return true;
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int[][] arr = new int[9][9];
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        arr[i][j] = scn.nextInt();
      }
    }
    scn.close();
    solveSudoku(arr, 0, 0);
  }
}
