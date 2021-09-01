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
    
    public static class RobberH{
        int profitWithR;
        int profitWithOutR;
        
        RobberH(int profitWithR, int profitWithOutR){
            this.profitWithR = profitWithR;
            this.profitWithOutR = profitWithOutR;
        }
    }

    public static int HouseRobber(TreeNode root) {
        
        RobberH res = HouseRobberH(root);
        
        return Math.max(res.profitWithR, res.profitWithOutR);
    }
    public static RobberH HouseRobberH(TreeNode node){
        if( node == null ){
            return new RobberH(0, 0);
        }
        
        RobberH lr = HouseRobberH(node.left);
        RobberH rr = HouseRobberH(node.right);
        
        int robHouse = node.val + lr.profitWithOutR + rr.profitWithOutR;
        int nrobHouse = Math.max(lr.profitWithR, lr.profitWithOutR) + Math.max(rr.profitWithR, rr.profitWithOutR);
        
        
        return new RobberH(robHouse, nrobHouse);
        
    }

    // input_Section_====================================================================

    public static TreeNode createTree(int[] arr, int[] IDX) {
        if (IDX[0] > arr.length || arr[IDX[0]] == -1){
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
        System.out.println(HouseRobber(root));
    }

    public static void main(String[] args) {
        solve();
    }
}