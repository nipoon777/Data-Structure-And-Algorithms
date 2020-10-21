package RecursionArrayLists;
import java.util.*;


public class SubSequence {

    public static void main(String[] args)  {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        ArrayList<String> res = gss(str);
        
        System.out.println(res);
        scn.close();

    }

    public static ArrayList<String> gss(String str) {
        
        if(str.length() == 0){
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }
        
        
        char ch = str.charAt(0);
        String ros = str.substring(1);
        
        ArrayList<String> rres = gss(ros);
        
        ArrayList<String> mres = new ArrayList<>();
        
        
        for(String rstr : rres){
            mres.add("" + rstr);    
        }
        for(String rstr : rres){
            mres.add(ch + rstr);    
        }
        return mres;
    }
    
}
