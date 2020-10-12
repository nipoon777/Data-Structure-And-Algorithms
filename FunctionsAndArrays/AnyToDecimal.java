package FunctionsAndArrays;

import java.util.*;
  
  public class AnyToDecimal{
  
  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      int n = scn.nextInt();
      int b = scn.nextInt();
      int d = getValueIndecimal(n, b);
      System.out.println(d);
      scn.close();
   }
  
   public static int getValueIndecimal(int n, int b){
      // write your code here
      int res = 0;
      int pow = 1;
      
      while( n != 0 ){
          int digit = n % 10;
          n = n / 10;
          res += pow*digit;
          pow *= b;
      }
      return res;
   }
  }
  
