package Level2.RecursionAndBackTrack;

import java.util.*;

public class Josephus {

  public static int solution(int n, int k){
    //write your code here
    if(n == 1){
        return 0;
    }
    
    int survivorFromNm1 = solution(n - 1, k);
    
    int ourMatch = (survivorFromNm1 + k) % n; 
    return ourMatch;
  }
  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int k = scn.nextInt();
    scn.close();
    System.out.println(solution(n,k));
  }
  

}
