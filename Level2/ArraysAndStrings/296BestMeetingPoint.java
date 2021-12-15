class Solution {
    public int minTotalDistance(int[][] grid) {
        ArrayList<Integer> x = new ArrayList<>();
        ArrayList<Integer> y = new ArrayList<>();
        
        // ADD all the X coordinates in Sorted order
        for(int i = 0 ; i < grid.length ; i++ ){
            for(int j = 0 ; j < grid[0].length ; j++ ){
                if( grid[i][j] == 1 ){
                    x.add(i);
                }
            }
        }
        
        // Add all the Y coordinates in Sorted Order
        
        for(int j = 0 ; j < grid[0].length ; j++ ){
            for(int i = 0 ; i < grid.length ; i++){
                if( grid[i][j] == 1){
                    y.add(j);
                }
            }
        }
        
        // Find the Meeting point which is going to be the median of X and Y arrayList
        
        int xmp = x.get(x.size() / 2);
        int ymp = y.get(y.size() / 2);
        
        // Find the Manhattan Distance 
        int dist = 0;
        for(int i = 0 ; i < x.size() ; i++ ){
            dist += (Math.abs(x.get(i) - xmp) + Math.abs(y.get(i) - ymp));   
        }
        
        return dist;
        
        
        
    }
}