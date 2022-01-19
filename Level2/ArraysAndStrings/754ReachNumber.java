class Solution {
    public int reachNumber(int target) {
        target = Math.abs(target);
        
        int jump = 0;
        int start = 0;
        
        while( start < target ){
            jump++;
            start += jump;
            
        }
        
        if( start == target ){
            return jump;
        }else if( (start - target) % 2 == 0 ){
            return jump;
        }else if( (start + jump + 1 - target) % 2 == 0 ){
            return jump + 1;
        }else{
            return jump + 2;
        }
    }
}