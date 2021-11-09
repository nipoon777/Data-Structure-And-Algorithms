import java.util.ArrayList;
import java.util.HashMap;

public class CodeSignalCoolFeature {
    public static void main(String[] args) {
    }

    public static int query2(ArrayList<Integer> a, ArrayList<Integer> b, int x){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int val : a){
            if( map.containsKey(val)){
                map.put(val, map.get(val) + 1);
            }else{
                map.put(val, 1);
            }
        }
        int count = 0;
        for(int val : b){
            if( map.containsKey(x - val)){
                count += map.get(x - val);
            }
        }
        return count;
    }
    public static void query1(ArrayList<Integer> nums, int i , int x){
        nums.set(i,x);
    }
    public static ArrayList<Integer> coolFeature(ArrayList <ArrayList<Integer>> queries, ArrayList<Integer> a, ArrayList<Integer> b){
        ArrayList<Integer> res = new ArrayList<>();
        for( int i = 0 ; i < queries.size() ; i++ ){
            if( queries.get(i).get(0) == 1 ){
                res.add(query2(a,b, queries.get(0).get(1)));
            }else{
                query1(b, queries.get(i).get(1), queries.get(i).get(2));
            }
        }
        return res;
    }
    
}
