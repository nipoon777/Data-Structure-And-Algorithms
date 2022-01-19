class Solution {
    public void rotate(int[][] matrix) {
        
        for(int i = 0 ; i < matrix.length ; i++ ){
            for(int j = i + 1; j < matrix[0].length ; j++ ){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        for(int r = 0 ; r < matrix.length ; r++ ){
            int left = 0;
            int right = matrix[0].length - 1;
            
            while( left < right ){
                int temp = matrix[r][left];
                matrix[r][left] = matrix[r][right];
                matrix[r][right] = temp;
                left++;
                right--;
            }
        }
    }
}