import java.util.*;

public class Main {
    
    public static List<List<Integer>> twoPair(int[] nums, int target, int st, int end){
        int left = st;
        int right = end;
        List<List<Integer>> res = new ArrayList<>();
        
        while( left < right ){
            if( left != st && nums[left] == nums[left - 1] ){
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
            }else if ( sum < target ){
                left++;
            }else{
                right--;
            }
        }
        
        return res;
    }

  // ~~~~~~~~~~~~User Section~~~~~~~~~~~~
  public static List<List<Integer>> threeSum(int[] nums, int targ) {
        List<List<Integer>> res = new ArrayList<>();
        if( nums.length < 3 ) return res;
        
        Arrays.sort(nums);
        for(int i = 0 ; i <= nums.length - 3 ; i++ ){
            if( i != 0 && nums[i] == nums[i - 1] ) continue;
            int nTarget = targ - nums[i];
            List<List<Integer>> twoPairRes = twoPair(nums, nTarget, i + 1, nums.length - 1);
            
            for(List<Integer> list : twoPairRes ){
                list.add(nums[i]);
                res.add(list);
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
    List<List<Integer>> res = threeSum(arr, target);
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