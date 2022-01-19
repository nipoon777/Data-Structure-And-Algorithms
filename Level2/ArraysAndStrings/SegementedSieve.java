import java.util.*;

public class Main {

  // ~~~~~~~~~~~~~User Section~~~~~~~~~~~~
  
  public static ArrayList<Integer> sieve(int n ){
      boolean[] isPrime = new boolean[n + 1];
      // False - prime
      // True - not Prime;
      
      for(int i = 2 ; i * i <= n ; i++ ){
          if( isPrime[i] == false ){
              for(int j = 2 * i ; j <= n ; j += i ){
                  isPrime[j] = true;
              }
          }
      }
      ArrayList<Integer> res = new ArrayList<>();
      
      for(int i = 2 ; i <= n ; i++ ){
            if( isPrime[i] == false ){
                res.add(i);
            }    
      }
      return res;
  }

  public static void segmentedSieveAlgo(int a, int b) {
    // 1. Find Root b
    int rootb = (int)Math.sqrt(b);
    // 2. Find All primes till rootb using Sieve
    
    ArrayList<Integer> primes = sieve(rootb);
    
    boolean[] isPrime = new boolean[b - a + 1];// False - Prime True - Not Prime
    
    //3. Once we have all the Primes the next job is to map the elements with
    // the indices of the boolean array;
    
    for(int prime : primes ){
        int multiple = (int) Math.ceil( (a * 1.0)/ prime );
        if( multiple == 1 ) multiple++;
        
        int idx = multiple * prime - a;
        for(int i = idx ; i < isPrime.length ; i += prime ){
            isPrime[i] = true;
        }
    }
    
    for(int i = 0 ; i < isPrime.length ; i++ ){
        if( isPrime[i] == false && a + i != 1 ){
            System.out.println(a + i);
        }
    }
    
  }

  // ~~~~~~~~~~~~Input Management~~~~~~~~~~~
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int a = scn.nextInt();
    int b = scn.nextInt();
    segmentedSieveAlgo(a, b);
  }
}
