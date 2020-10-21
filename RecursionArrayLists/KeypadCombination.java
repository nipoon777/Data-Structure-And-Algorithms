package RecursionArrayLists;

import java.util.*;

public class KeypadCombination {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();

        ArrayList<String> res = getKPC(str);

        System.out.println(res);

        scn.close();
    }
    static String[] codes = {".;","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};

    
    public static ArrayList<String> getKPC(String str){

        if(str.length()== 0){
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }

        char ch = str.charAt(0);
        String ros = str.substring(1);

        ArrayList<String> rres = getKPC(ros);

        String codeForCh = codes[ch - '0'];

        ArrayList<String> mres = new ArrayList<>();

        for(int i = 0 ; i < codeForCh.length(); i++){

            char codech = codeForCh.charAt(i);

            for(String rstr : rres){
                mres.add(codech + rstr);
            }
        }

        return mres;
    }
    
}
