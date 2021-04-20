package Level2.RecursionAndBackTrack;

import java.util.*;

public class MaxScore {

	public static int solution(String[] words, int[] farr, int[] score, int idx) {
	    if(idx == words.length ){
	        return 0;
	    }
		int scoreWordNotIncluded = solution(words, farr, score, idx + 1);
		
		int scoreWord = 0;
		String word = words[idx];
		boolean wordAllowed = true;
		
		for(int i = 0 ; i < word.length() ; i++ ){
		    char ch = word.charAt(i);
		    
		    if(farr[ch -'a'] == 0 ){
		        wordAllowed = false;
		    }
		    farr[ch - 'a']--;
		    
		    scoreWord += score[ch - 'a'];
		}
		int scoreWordIncluded = 0;
		
		if(wordAllowed){
		    scoreWordIncluded = scoreWord + solution(words, farr, score, idx + 1);    
		}
		for(int i = 0 ; i < word.length() ; i++ ){
		    char ch = word.charAt(i);
		    farr[ch - 'a']++;
		}
		
		
		return Math.max(scoreWordNotIncluded,scoreWordIncluded);
	}

	public static void main(String[] args) {

		Scanner scn = new Scanner( System.in );
		int noWords = scn.nextInt();
		
		String[] words = new String[noWords];
		
		for(int i = 0 ; i < words.length ; i++ ){
		    words[i] = scn.next();
		}
		
		int noLetters = scn.nextInt();
		
		char[] letters = new char[noLetters];
		
		for(int i = 0 ; i < letters.length ; i++ ){
		    letters[i] = scn.next().charAt(0);
		}
		
		int[] scores = new int[26];
		
		for(int i = 0 ; i < scores.length ; i++ ){
		    scores[i] = scn.nextInt();
		}
        scn.close();
		if (words == null || words.length == 0 || letters == null || letters.length == 0 || scores == null
				|| scores.length == 0) {
			System.out.println(0);
			return;
		}
		
		int[] farr = new int[scores.length];
		
		for(char ch : letters){
		    farr[ch -'a']++;
		}
        
		
		System.out.println(solution(words, farr,scores,0) );

	}
}
