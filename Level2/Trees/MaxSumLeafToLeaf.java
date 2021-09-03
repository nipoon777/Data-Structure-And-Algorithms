import java.util.Scanner;

public class Main {
  public static Scanner scn = new Scanner(System.in);

  public static class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    TreeNode(int val) {
      this.val = val;
    }
  }
  
  public static int LTLmaxSum = 0;
  public static int maxPathSum(TreeNode root){
      maxPathSumH(root);
      return LTLmaxSum;
  }

  public static int maxPathSumH(TreeNode root) {
    if( root == null ){
        return 0;
    }
    
    
    int lntlmaxSum = maxPathSumH(root.left);
    int rntlmaxSum = maxPathSumH(root.right);
    
    int ntlmaxSum = Integer.max(lntlmaxSum, rntlmaxSum) + root.val;
    if( root.left != null && root.right != null ){
        int nltlmaxSum = lntlmaxSum + rntlmaxSum + root.val;
        if( nltlmaxSum > LTLmaxSum){
            LTLmaxSum = nltlmaxSum;
        }
    }
    
    return ntlmaxSum;
  }

  // input_Section=================================================

  public static TreeNode createTree(int[] arr, int[] IDX) {
    if (IDX[0] > arr.length || arr[IDX[0]] == -1) {
      IDX[0]++;
      return null;
    }

    TreeNode node = new TreeNode(arr[IDX[0]++]);
    node.left = createTree(arr, IDX);
    node.right = createTree(arr, IDX);

    return node;
  }

  public static void solve() {
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++)
      arr[i] = scn.nextInt();

    int[] IDX = new int[1];
    TreeNode root = createTree(arr, IDX);
    System.out.println(maxPathSum(root));
  }

  public static void main(String[] args) {
    solve();
  }
}