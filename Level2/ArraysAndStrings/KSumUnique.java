import java.util.*;

public class Main {

  public static List<List<Integer>> kSum(int[] arr, int target, int k) {
    // We use Recursive method to solve the Ksum Problem
    // We know to Calculte 3 sum we take one value and Final the target value of remaining elements
    // We are applying the similar logic here to get kSum;
    Arrays.sort(arr);
    int n = arr.length;
    
    List<List<Integer>> res = kSumHelper(arr, target, k, n, 0);
    
    return res;
  }
  
  public static List<List<Integer>> kSumHelper(int[] arr, int target, int k, int n, int si){
      if( k == 2 ){
          return twoSum(arr, target,n, si);
      }
      
      List<List<Integer>> res = new ArrayList<>();
      
      for(int i = si ; i < n - (k - 1) ; i++){
        if( i != si && arr[i -1] == arr[i] ) continue;
        int val = arr[i];
        int rtarg = target - val;
        
        List<List<Integer>> mres = kSumHelper(arr,rtarg, k - 1, n, i + 1);
        
        for(List<Integer> list : mres ){
            list.add(val);
            res.add(list);
        }
      }
      return res;
  }
  public static List<List<Integer>> twoSum(int[] arr, int target, int n, int si ){
      int left = si;
      int right = n -1;
      List<List<Integer>> res = new ArrayList<>();
      
      while( left < right ){
            if( left != si && arr[left] == arr[left - 1] ){
                left++;
                continue;
            }      
          
            int sum = arr[left] + arr[right];
            if( sum == target ){
                List<Integer> subRes = new ArrayList<>();
                subRes.add(arr[left]);
                subRes.add(arr[right]);
                left++;
                right--;
                res.add(subRes);
            }else if( sum < target ){
                left++;
            }else{
                right--;
            }
      }
      
      return res;
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }
    int target = scn.nextInt();
    int k = scn.nextInt();
    List<List<Integer>> res = kSum(arr, target, k);
    ArrayList<String> finalResult = new ArrayList<>();
    for (List<Integer> list : res) {
      Collections.sort(list);
      String ans = "";
      for (int val : list) {
        ans += val + " ";
      }
      finalResult.add(ans);
    }
    Collections.sort(finalResult);
    for (String str : finalResult) {
      System.out.println(str);
    }
  }

}