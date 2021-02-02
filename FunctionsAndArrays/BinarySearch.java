package FunctionsAndArrays;


public class BinarySearch {


    public static void main(String[] args) {

        int arr[] = {
            8,
            16,
            24,
            32,
            49,
            67,
            70,
            78,
            90
        };

        int ele = 90;

        System.out.println(binarySearch(arr, ele));
    }
    
    public static int binarySearch(int[] arr, int ele){
        int lo = 0;
        int hi = arr.length - 1;
        
        while( lo <= hi ){
            int mid = (lo + hi) / 2;
            
            if( ele == arr[mid] ){
                return mid;
            }else if( ele < arr[mid] ){
                //Smaller Region
                hi = mid - 1;
            }else{
                //Larger Region
                lo = mid + 1;
            }
        }
        
        return -1;
    }
}