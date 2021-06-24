import java.io.*;
import java.util.*;

public class Main {
    
    public static void wordPermutations(String ustr, int ts, int ci, HashMap<Character, Boolean> hmap, String asf){
        if( ci == ts ){
            System.out.println(asf);
            return;
        }
        for(char ch : ustr.toCharArray() ){
            if( hmap.get(ch) == false ){
                hmap.put(ch, true);
                wordPermutations(ustr,ts, ci + 1, hmap, asf + ch );
                hmap.put(ch, false);
            }
        }
    }
    
    
 
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    int k = Integer.parseInt(br.readLine());

    HashSet<Character> unique = new HashSet<>();
    String ustr = "";
    for (char ch : str.toCharArray()) {
      if (unique.contains(ch) == false) {
        unique.add(ch);
        ustr += ch;
      }
    }
    HashMap<Character, Boolean> hmap = new HashMap<>();
    for(char ch : ustr.toCharArray() ){
        hmap.put(ch, false);
    }
    
    wordPermutations(ustr, k, 0, hmap,"");

   
  }

}