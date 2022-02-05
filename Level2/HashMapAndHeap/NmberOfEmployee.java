import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
   
    int n = scn.nextInt();
    
    HashMap <String, ArrayList<String> > hmap = new HashMap<>();
    String root = "";
    for(int i = 0 ; i < n ; i++ ){
        
        
        
        String e1 = scn.next();
        String m1 = scn.next();
        if( e1.equals(m1) ) {
            root = e1;
        }else{
            if( hmap.containsKey(m1) ){
                ArrayList<String> empl = hmap.get(m1);
                empl.add(e1);
                hmap.put(m1, empl);
            } else{
                ArrayList<String> empl = new ArrayList<>();
                empl.add(e1);
                hmap.put(m1, empl);
            }
        }
    }
    printCountEmployees(hmap, root);
  }
  
  public static int printCountEmployees(HashMap<String, ArrayList<String> > hmap, String root){
      int count = 0;
      if( hmap.get(root) == null ){
          System.out.println( root + " 0");
          return 1;
      } 
      for( String ch : hmap.get(root) ){
          count += printCountEmployees(hmap, ch);
      }
      System.out.println( root + " " + count);
      
      return count + 1;
  }
  
  

}