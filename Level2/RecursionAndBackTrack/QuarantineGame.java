import java.util.*;

public class QuarantineGame {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();

        int count = 0;

        for(int li = 0 ; li < str.length() ; li++ ){
            for(int ri = li ; ri < str.length() ; ri++ ){
                if( str.charAt(li) == str.charAt(ri)){
                    count++;
                }
            }
        }
        System.out.println(count);
        scn.close();
    }
}
