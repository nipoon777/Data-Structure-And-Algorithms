import java.util.*;

public class Main {

  public static List<List<Integer>> fourSum(int[] nums, int target) {
        //1. Sort the nums array
        //Har ek element ko target se minus karenge aur phir 3 Sum ko solve karne bolna hai
        Arrays.sort(nums);
        // Last mai atleast 3 elements hone chahiye iss liye loop 0 - n - 3 tak hi chalana hai
        
        int n = nums.length;
        
        List<List<Integer>> res = new ArrayList<>();
        
        for(int i = 0 ; i < n - 3; i++ ){
           
            if( i != 0 && nums[i -1] == nums[i]) continue;           
            int val = target - nums[i];
            
            List<List<Integer>> threeSumRes = threeSum(nums, val, i+ 1);
            
            for(List<Integer> list : threeSumRes ){
                list.add(nums[i]);
                res.add(list);
            }
            
        }
        return res;
  }
  
  public static List<List<Integer>> threeSum(int[] nums, int target, int si){
      List<List<Integer>> res = new ArrayList<>();
      
      int n = nums.length;
      
      for(int i = si; i < n - 2; i++ ){
          if( i != si && nums[i-1] == nums[i] )continue;
          int ntarg = target - nums[i];
          
          List<List<Integer>> twoSumRes = twoSum(nums, ntarg, i + 1);
          for(List<Integer> list : twoSumRes ){
                list.add(nums[i]);
                res.add(list);
            }
          
      }
      return res;
  }
  
  public static List<List<Integer>> twoSum(int[] nums, int target, int si ){
      List<List<Integer>> res = new ArrayList<>();
      int n = nums.length;
      int left = si;
      int right = nums.length - 1;
      
      while( left < right ){
          if( left != si && nums[left] == nums[left -1] ) {
              left++;
              continue;
          }
          int sum = nums[left] + nums[right];
          
          if( sum == target ){
            List<Integer> subRes = new ArrayList<>();
            subRes.add(nums[left]);
            subRes.add(nums[right]);
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

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }
    int target = scn.nextInt();
    List<List<Integer>> res = fourSum(arr, target);
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