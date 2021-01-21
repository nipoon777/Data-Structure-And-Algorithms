package HashMap;

import java.util.*;

public class Basics {

    public static void main(String[] args) {

        HashMap <String, Integer> hm = new HashMap <>();
        
        hm.put("India", 135);
        hm.put("US", 36);
        hm.put("England", 12);
        hm.put("New Zealand", 2);
        
        System.out.println(hm);
        // Either update karega nahi toh modify karega
        hm.put("China", 200);
        hm.put("England", 5);
        
        System.out.println(hm);
        
        // Present hoga toh value dega nahi toh null return karega
        System.out.println(hm.get("India"));
        System.out.println(hm.get("Nigeria"));
        
        // Present hoga toh true nahi toh false return hoga
        System.out.println(hm.containsKey("India"));
        System.out.println(hm.containsKey("Nigeria"));
        
        //Pura Key Set Return karke dega
        Set <String> keys = hm.keySet();
        
        System.out.println(keys);
        
        for(String key : hm.keySet() ){
            int val = hm.get(key);
            
            System.out.println(key + " " + val);
        }

    }
}
