import java.util.*;

public class Permutation1 {

  public static void permutations(int[] boxes, int ci, int ti){
    if( ci > ti ){
        for(int val : boxes){
            System.out.print(val);
        }
        System.out.println();
        return;
    }
    // write your code here
    for(int box = 0 ; box < boxes.length ; box++ ){
        if( boxes[box] == 0 ){
            boxes[box] = ci;
            permutations(boxes, ci + 1, ti);
            boxes[box] = 0;
        }
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int nboxes = Integer.parseInt(br.readLine());
    int ritems = Integer.parseInt(br.readLine());
    permutations(new int[nboxes], 1, ritems);
  }

}