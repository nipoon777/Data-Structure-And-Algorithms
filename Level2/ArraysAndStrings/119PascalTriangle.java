class Solution {
    public List<Integer> getRow(int n) {
        List<Integer> res = new ArrayList<>();
        long val = 1;
        
        for(int r = 0; r <= n ; r++ ){
            res.add((int)val);
            val = (val * (n - r) ) /( r + 1);
        }
        return res;
    }
}