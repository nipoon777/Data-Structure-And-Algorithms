import java.io.*;
import java.util.*;

public class Main {

  public static void permutations(int cb, int tb, int[] items, int ssf, int ts, String asf){
      
      if( cb > tb ){
          if( ssf == ts ){
              System.out.println(asf);
          }
          return;
      }
      for(int item = 0 ; item < items.length ; item++ ){
          if( items[item] == 0){
              items[item] = 1;
              permutations(cb + 1, tb, items, ssf + 1, ts, asf + (item + 1) );
              items[item] = 0;
          }
      }
      permutations(cb + 1, tb, items, ssf, ts, asf + 0);
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int nboxes = Integer.parseInt(br.readLine());
    int ritems = Integer.parseInt(br.readLine());
    permutations(1, nboxes, new int[ritems], 0, ritems, "");
  }

}