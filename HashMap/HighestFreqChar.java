package HashMap;

import java.io.*;
import java.util.*;

public class HighestFreqChar {

    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String str = br.readLine();
        getFrequency(str);
    }
    
    public static void getFrequency(String str){
        HashMap < Character, Integer > hm = new HashMap<>();
        
        for(int i = 0 ; i < str.length() ; i++){
            char ch = str.charAt(i);
            if(hm.containsKey(ch)){
                int of = hm.get(ch);
                int nf = of + 1;
                hm.put(ch, nf);
            }else{
                hm.put(ch, 1);
            }
        }
        
        char mfc = str.charAt(0);
        
        for(Character key : hm.keySet() ){
            if(hm.get(key) > hm.get(mfc)){
                mfc = key;
            }
        }
        System.out.println(mfc);
    }

}
