class Solution {
    public double[] getCollisionTimes(int[][] cars) {
        Stack<Integer> st = new Stack<>();
        int n = cars.length;
        
        double[] res = new double[n];
        
        for(int i = n - 1; i >= 0 ; i-- ){
            res[i] = -1;
             int p = cars[i][0];
             int s = cars[i][1];
            while( st.size() > 0 ){
                        
                int j = st.peek();
                
                int p1 = cars[j][0], s1 = cars[j][1];
                
                if( s <= s1 || ( p1 - p )/( 1.0 *( s - s1)) > res[j] && res[j] > 0 ){
                    st.pop();
                }else{
                    break;
                }
                
            }
            if( st.size() > 0 ){
                int j = st.peek();
                
                int p1 = cars[j][0], s1 = cars[j][1];
                res[i] = ( p1 - p )/( 1.0 *( s - s1));
            }
            
            st.push(i);
        }
        return res;
        
    }
}