import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int noOfTrips = scn.nextInt();
		
		HashMap<String, String> pair = new HashMap<>();
		
		HashMap<String, Boolean> source = new HashMap<>();
		
		for(int i = 0 ; i < noOfTrips ; i++ ){
		    String src = scn.next();
		    String dest = scn.next();
		    
		    pair.put(src, dest);
		    if( !source.containsKey(src) ){
		         source.put(src, true);
		    }
		    source.put(dest, false);
		    
		}
		
		String mainSrc = "";
		
		for( String city : source.keySet() ){
		    if( source.get(city) ){
		        mainSrc = city;
		        break;
		    }
		}
		
		    
		
		while( pair.get(mainSrc) != null ){
		    System.out.print( mainSrc + " -> ");
		    mainSrc = pair.get(mainSrc);
		}
		System.out.println(mainSrc + ".");
	
	}


}
