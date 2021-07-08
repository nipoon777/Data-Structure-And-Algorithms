import java.io.*;
import java.util.*;

public class Main {

  public static void permutationRep(String str, int idx, HashMap<Character, Integer> lastOcc, int ssf, int ts, Character[] spots){
      if( idx == str.length() ){
          if( ts == ssf ){
              for(char ch : spots){
                  System.out.print(ch);
              }
              System.out.println();
          }
          return;
      }
      char ch = str.charAt(idx);
      int lcno = lastOcc.get(ch);
      
      for(int i = lcno + 1; i < spots.length ; i++ ){
          if( spots[i] == null ){
              lastOcc.put(ch, i);
              spots[i] = ch;
              permutationRep(str, idx + 1, lastOcc, ssf + 1, ts, spots);
              lastOcc.put(ch, lcno);
              spots[i] = null;
          }
      }
      
      if( lcno == -1 ){
          permutationRep(str, idx + 1, lastOcc, ssf, ts, spots);
      }
  }
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    int k = Integer.parseInt(br.readLine());

    HashMap <Character, Integer> lastOccurence = new HashMap<>();
    
    for(char ch : str.toCharArray() ){
        lastOccurence.put(ch, -1);
    }
    
    permutationRep(str, 0, lastOccurence, 0, k, new Character[k]);
   
  }

}
