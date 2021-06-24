import java.io.*;
import java.util.*;

public class Main {
  public static void wordsPermutation(int ts, int ssf, String ustr, int ci, Character[] spots){
      
      if( ci == ustr.length() ){
          if( ssf == ts ){
              for(char ch : spots){
                  System.out.print(ch);
              }
              System.out.println();
          }
        return;
      }
      
      for(int i = 0 ; i < spots.length ; i++ ){
          if( spots[i] == null ){
              spots[i] = ustr.charAt(ci);
              wordsPermutation(ts, ssf + 1, ustr, ci+1, spots);
              spots[i] = null;
          }
      }
      wordsPermutation(ts, ssf, ustr, ci + 1, spots);
      
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
    
    wordsPermutation(k, 0, ustr, 0, new Character[k]);
    
  }

}