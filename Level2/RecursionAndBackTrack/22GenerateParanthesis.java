class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        int open = n;
        int close = n;
        String asf = "";
        
        solve(open, close, res, asf);
        
        return res;
        
    }
    
    public void solve(int open, int close, List<String> res, String asf){
        if( open  == 0 && close == 0){
            res.add(asf);
        }
        
        if( open > 0 ){
            solve(open - 1, close, res, asf + "(");
        }
        if( close > open ){
            solve(open, close - 1, res, asf + ")");
        }
    }
}