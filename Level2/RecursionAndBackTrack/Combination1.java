import java.io.*;
import java.util.*;

public class Combination1 {

  public static void combinations(int[] boxes, int ci, int ti, int lb){
      
      if( ci > ti ){
          for(int val : boxes){
              if(val != 0 ){
                System.out.print("i");
              }else{
                  System.out.print("-");
              }
          }
          System.out.println();
          return;
      }
    // write your code here
    for(int box = lb + 1 ; box < boxes.length ; box++ ){
        boxes[box] = ci;
        combinations(boxes, ci + 1, ti, box);
        boxes[box] = 0;
        
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int nboxes = Integer.parseInt(br.readLine());
    int ritems = Integer.parseInt(br.readLine());
    combinations(new int[nboxes], 1, ritems, -1);
  }

}