package HashMap;

import java.util.*;

public class Revision {

    public static void getHgtFreq(String str) {
        HashMap < Character, Integer > map = new HashMap < > ();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);

            } else {
                map.put(ch, 1);
            }
        }
        char mfc = str.charAt(0);

        for (char key: map.keySet()) {
            if (map.get(key) > map.get(mfc)) {
                mfc = key;
            }
        }
        System.out.println(mfc);
    }
    
    public static void containsElements1( int[] arr1, int[] arr2){
        HashMap <Integer, Integer> map = new HashMap<>();
        
        for(int val : arr1){
            if( map.containsKey(val) ){
                map.put(val, map.get(val) + 1);
            }else{
                map.put(val, 1);
            }
        }
        
        for(int val : arr2){
            if( map.containsKey(val) ){
                System.out.print(val + " ");
                map.remove(val);
            }
        }
        System.out.println();
        
    }
    
    public static void containsElements2(int[] arr1, int[] arr2){
        HashMap <Integer,Integer> map = new HashMap<>();
        
        for(int val : arr1){
            if( map.containsKey(val) ){
                map.put(val, map.get(val) + 1);
            }else{
                map.put(val, 1);
            }
        }
        
        for(int val : arr2){
            if( map.containsKey(val) && map.get(val) > 0){
                System.out.print(val + " ");
                map.put(val, map.get(val) - 1);
            }
        }
        System.out.println();
    }

    public static void longestConSeq(int[] arr){
        HashMap <Integer, Boolean> map = new HashMap<>();
        for(int val : arr){
            map.put(val, true);
        }
        
        for(int val : arr){
            if(map.containsKey(val -1) ){
                map.put(val, false);
            }
        }
        int ml = 0;
        int strtPt = 0;
        for(int val : arr){
            if(map.get(val)){
                int tl = 1;
                
                while(map.containsKey(val + tl) ){
                    tl++;
                }
                
                if(ml < tl){
                    ml = tl;
                    strtPt = val;
                }
            }
        }
        
        for(int i = 0 ; i < ml ; i++){
            System.out.print((strtPt + i) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        getHgtFreq(str);

        int n1 = scn.nextInt();

        int[] arr1 = new int[n1];

        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = scn.nextInt();
        }

        int n2 = scn.nextInt();

        int[] arr2 = new int[n2];

        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = scn.nextInt();
        }

        containsElements1(arr1, arr2);
        containsElements2(arr1, arr2);
        
        int n3 = scn.nextInt();
        
        int[] arr3 = new int[n3];
        
        for(int i = 0 ;i < arr3.length ; i++){
            arr3[i] = scn.nextInt();
        }
        
        longestConSeq(arr3);

    }
}
