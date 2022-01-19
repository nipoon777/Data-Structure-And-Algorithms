class Solution {
    public void swap(char[] arr, int i, int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        
    }
    public int maximumSwap(int num) {
        String value = num + "";
        //1. To convert to charArray;
        
        char[] arr = value.toCharArray();
        
        //2. Find the lastOccurence of each number;
        
        int[] lastIdxOfValue = new int[10];
        for(int i = 0 ; i < arr.length ;i++ ){
            lastIdxOfValue[arr[i] - '0'] = i;
        }
        
        //3. Swap with the first Greater value;
        
        for(int i = 0 ; i < arr.length ; i++ ){
            int digit = arr[i] - '0';
            int idx = i;
            for(int j = 9 ; j > digit ; j--){
                if( lastIdxOfValue[j] > idx ){
                    swap(arr, lastIdxOfValue[j], idx );
                    idx = j;
                    break;
                }
            }
            if( idx != i ){
                break;
            }
        }
        value = String.valueOf(arr);
        return Integer.parseInt(value);
        
        
    }
}