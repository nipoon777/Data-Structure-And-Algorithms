import java.util.*;

public class Main {

  // ~~~~~~~~~~~~User Section~~~~~~~~~~~~
  public static List<List<Integer>> twoSum(int[] arr, int target) {
      List<List<Integer>> res = new ArrayList<>();
      
      Arrays.sort(arr);
      // Same step follow karne vale hai jo traget sum subset mai kara tha
      
      int left = 0;
      int right = arr.length - 1;
      
      while( left < right ){
          if( left != 0 && arr[left - 1]  == arr[left] ){
              left++;
              continue;
          }
          int sum = arr[left] + arr[right];
          
          if( sum == target ){
              List<Integer> subRes = new ArrayList<>();
              subRes.add(arr[left]);
              subRes.add(arr[right]);
              
              res.add(subRes);
              left++;
              right--;
          }else if( sum < target ){
              left++;
          }else{
              right--;
          }
      }
      
      return res;
  }

  // ~~~~~~~~~~Input Management~~~~~~~~~~
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }
    int target = scn.nextInt();
    List<List<Integer>> res = twoSum(arr, target);
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