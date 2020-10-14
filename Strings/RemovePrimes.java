package Strings;
import java.util.*;


public class RemovePrimes {
    public static boolean isPrime(int n) {
        for(int div = 2 ; div*div <= n ; div++){
            if(n % div == 0)
            return false;
        }
        return true;
    }

    public static void removePrimes(ArrayList<Integer> list){
        for(int i = list.size() - 1 ; i >= 0 ; i--){
            if(isPrime(list.get(i))){
                list.remove(i);
            }
        }
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();

        int n = scn.nextInt();

        for(int i = 0 ; i < n ; i++){
            list.add(scn.nextInt());
        }
        removePrimes(list);
        System.out.println(list);
        scn.close();
    }
    
}
