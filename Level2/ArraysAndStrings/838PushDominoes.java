class Solution {
    private void solveConfig(char[] arr, int i, int j){
        if( arr[i] == 'L' && arr[j] == 'L' ){
            for(int k = i + 1; k < j; k++){
                arr[k] = 'L';
            }
        }else if( arr[i] == 'R' && arr[j] == 'R' ){
            for(int k = i + 1; k < j; k++){
                arr[k] = 'R';
            }
        }else if( arr[i] == 'L' && arr[j] == 'R' ){
            //Nothing to Do
            return;
        }else{
            i++;
            j--;
            while( i < j ){
                arr[i] = 'R';
                arr[j] ='L';
                i++;
                j--;
            }
            
        }
    }
    public String pushDominoes(String dominoes) {
        int len = dominoes.length();
        
        char[] arr = new char[len + 2];
        
        arr[0] = 'L';
        arr[len + 1] = 'R';
        for(int k = 1 ; k <= len ; k++ ){
            arr[k] = dominoes.charAt(k - 1);
        }
        
        int i = 0;
        int j = 1;
        
        while( j < arr.length ){
            while( arr[j] == '.'){
                j++;
            }
            
            if( j - i > 1 ){
                solveConfig(arr, i, j);
            }
            i = j;
            j++;
        }
        StringBuilder res = new StringBuilder();
        
        for(int k = 1 ; k <= len ; k++ ){
            res.append(arr[k]);
        }
        return res.toString();
    }
}