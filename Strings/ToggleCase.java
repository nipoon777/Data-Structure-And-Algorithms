package Strings;

import java.util.*;

public class ToggleCase {
    public static String toggleCase(String str){
		//write your code here
		StringBuilder sb = new StringBuilder(str);
		
		for(int i = 0 ;i < sb.length() ; i++){
		    char ch = sb.charAt(i);
		    if( ch >= 'a' && ch <='z'){
		        char uch = (char)('A' + ch - 'a');
		        sb.setCharAt(i, uch);
		    }else{
		        char lch = (char)('a' + ch - 'A');
		        sb.setCharAt(i, lch);
		    }
		}

		return sb.toString();
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
        System.out.println(toggleCase(str));
        scn.close();
	} 
}
