public class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int val1 = tops[0];
        int val2 = bottoms[0];
        
        int count1 = 0; // Rotations to make Tops equal to Val1
        int count2 = 0; // Rotations to make Tops equal to Val2
        int count3 = 0; // Rotations to make Bottom equal to Val2
        int count4 = 0; // Rotations to make Bottom equal to Val1
        
        
        for(int i = 0 ; i < tops.length ; i++ ){
            // To make top Val1
            if( count1 != Integer.MAX_VALUE ){
                if( tops[i] == val1 ){
                    //Nothing to do
                }else if( bottoms[i] == val1 ){
                    //One rotation is possible
                    count1++;
                }else{
                    count1 = Integer.MAX_VALUE;
                }
            }
            //To make top Val2
            if( count2 != Integer.MAX_VALUE ){
                if( tops[i] == val2 ){
                    //Nothing to do
                }else if( bottoms[i] == val2 ){
                    //One rotation is possible
                    count2++;
                }else{
                    count2 = Integer.MAX_VALUE;
                }
            }
            
            // To make bottom Val2
            
            if( count3 != Integer.MAX_VALUE ){
                if( bottoms[i] == val2 ){
                    //Nothing to do
                }else if( tops[i] == val2 ){
                    //One rotation is possible
                    count3++;
                }else{
                    count3 = Integer.MAX_VALUE;
                }
            }
            
            // To make Bottom Val1
            
            if( count4 != Integer.MAX_VALUE ){
                if( bottoms[i] == val1 ){
                    //Nothing to do
                }else if( tops[i] == val1 ){
                    //One rotation is possible
                    count4++;
                }else{
                    count4 = Integer.MAX_VALUE;
                }
            }
            
        }
        
        
        int res = Math.min( count1, Math.min( count2, Math.min(count3, count4)));
        
        
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
