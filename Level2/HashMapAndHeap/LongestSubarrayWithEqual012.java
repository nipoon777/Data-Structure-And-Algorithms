import java.util.*;

public class Main {

    public static int solution(int[] arr) {
        // write your code here
        HashMap < String, Integer> code = new HashMap<>();
        
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;
        
        int len = 0;
        
        code.put("0#0", -1);
        
        for(int i = 0 ; i < arr.length ; i++ ){
            count0 = arr[i] == 0 ? count0 + 1 : count0;
            count1 = arr[i] == 1 ? count1 + 1 : count1;
            count2 = arr[i] == 2 ? count2 + 1 : count2;
            
            String ccode = (count1-count0) + "#" + (count2 - count1);
            // System.out.println(ccode);
            if( code.containsKey(ccode) ){
                len = Math.max( len, i - code.get(ccode) );
                
            }else{
                code.put(ccode, i);
            }
        }

        return len;
    }
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        System.out.println(solution(arr));
    }

}
