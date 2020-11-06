package RecursionBackTracking;

import java.util.*;

public class KnightsTour {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int r = scn.nextInt();
        int c = scn.nextInt();

        int[][] chess = new int[n][n];

        printKnightTour(chess, r, c, 1);
        scn.close();
    }

    public static void printKnightTour(int[][] chess, int row, int col, int level) {
        
        if(row < 0 || col < 0 || row >= chess.length || col >= chess.length || chess[row][col] > 0){
            return;
        }

        if(level == chess.length * chess.length){
            chess[row][col] = level;
            displayBoard(chess);
            chess[row][col] = 0;
            return;

            

        }
        chess[row][col] = level;
        printKnightTour(chess, row - 2, col + 1, level + 1);
        printKnightTour(chess, row - 1, col + 2, level + 1);
        printKnightTour(chess, row + 1, col + 2, level + 1);
        printKnightTour(chess, row + 2, col + 1, level + 1);
        printKnightTour(chess, row + 2, col - 1, level + 1);
        printKnightTour(chess, row + 1, col - 2, level + 1);
        printKnightTour(chess, row - 1, col - 2, level + 1);
        printKnightTour(chess, row - 2, col - 1, level + 1);
        chess[row][col] = 0;
        
    }
    
    public static void displayBoard(int[][] chess){
        for(int i = 0; i < chess.length; i++){
            for(int j = 0; j < chess[0].length; j++){
                System.out.print(chess[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
    }
}
