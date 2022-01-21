class Solution {
    public int trap(int[] height) {
        Stack <Integer> st = new Stack<>();
        int n = height.length;
        int area = 0;
        
        for(int i = 0 ; i < n ; i++ ){
            while( st.size() > 0 && height[st.peek()] < height[i] ){
                int curr = height[st.pop()];
                int rightMax = height[i];
                if( st.size() == 0) break;
                int leftMaxIdx = st.peek();
                
                int width = i - leftMaxIdx - 1;
                int oheight = Integer.min(height[i], height[st.peek()]);
                
                area += (oheight - curr) * width;
                
            }
            st.push(i);
        }
        
        return area;   
    }
}
