package FunctionsAndArrays;

import java.util.*;
  
  public class AnyToAny{
  
  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      int n = scn.nextInt();
      int sourceBase = scn.nextInt();
      int  destBase= scn.nextInt();
      
      int dec = getValueIndecimal(n, sourceBase);
      int res = getDecimalToAny(dec, destBase);
      
      System.out.println(res);
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
   public static int getDecimalToAny(int n , int b) {

        int res = 0;
        int pow = 1;

        while( n != 0){
            int digit = n % b ;
            n = n / b;
            res += digit * pow;
            pow *= 10;
        }
        return res;
        
    }
  }
