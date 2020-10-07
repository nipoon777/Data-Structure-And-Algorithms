package FunctionsAndArrays;

import java.io.*;
import java.util.*;

public class SpanArray{

public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    
    int n = scn.nextInt();
    int [] arr = new int[n];
    
    for(int i = 0 ; i < arr.length ; i++){
        arr[i] = scn.nextInt();
    }
    
    int max = arr[0];
    int min = arr[0];
    
    for(int i = 1 ; i < arr.length ; i++){
        if(max <= arr[i])
            max = arr[i];
        if(min >= arr[i])
            min = arr[i];
    }
    System.out.println(max - min);
    
}

}