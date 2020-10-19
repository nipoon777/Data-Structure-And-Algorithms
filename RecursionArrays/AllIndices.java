package RecursionArrays;

import java.io.*;

public class AllIndices {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        for(int i = 0 ; i < n ; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int x = Integer.parseInt(br.readLine());

        int[] ai = allIndices(arr,x, 0 , 0);

        if(ai.length == 0){
            System.out.println();
            return;
        }
        for(int i = 0 ; i < ai.length ; i++){
            System.out.println(ai[i]);
        }
        
    }

    public static int[] allIndices(int[] arr, int x , int idx, int fsf){
        if(idx == arr.length){
            return new int[fsf];
        }
        if(arr[idx] == x){
            int[] res = allIndices(arr,x, idx + 1, fsf + 1);
            res[fsf] = idx;
            return res;
        }
        else{
            int[] res = allIndices(arr,x, idx + 1, fsf);
            return res;
        }
    }
    
}
