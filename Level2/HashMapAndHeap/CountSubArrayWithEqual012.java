import java.util.*;

public class Main {

    public static int solution(int[] arr) {
        HashMap < String, Integer> code = new HashMap<>();
        
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;
        
        int count = 0;
        
        code.put("0#0", 1);
        
        for(int i = 0 ; i < arr.length ; i++ ){
            count0 = arr[i] == 0 ? count0 + 1 : count0;
            count1 = arr[i] == 1 ? count1 + 1 : count1;
            count2 = arr[i] == 2 ? count2 + 1 : count2;
            
            String ccode = (count1-count0) + "#" + (count2 - count1);
            // System.out.println(ccode);
            if( code.containsKey(ccode) ){
                int freq = code.get(ccode);
                count += freq;
                code.put(ccode, freq + 1);
            }else{
                code.put(ccode, 1);
            }
        }

        return count;
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
