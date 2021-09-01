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
    
    public static class ZigZag{
        int fzpl;
        int bzpl;
        int mzpl;
        ZigZag(int fzpl, int bzpl, int mzpl ){
            this.fzpl = fzpl;
            this.bzpl = bzpl;
            this.mzpl = mzpl;
        }
    }
    
    public static int longestZigZagPath(TreeNode root) {
        ZigZag res = longestZigZag(root);
        
        return res.mzpl;
    }
    
    public static ZigZag longestZigZag(TreeNode node){
        if( node == null ){
            return new ZigZag(-1, -1, 0);
        }
        
        ZigZag lres = longestZigZag(node.left);
        ZigZag rres = longestZigZag(node.right);
        
        int fzpl = lres.bzpl + 1;
        int bzpl = rres.fzpl + 1;
        
        int mzpl = Math.max(rres.mzpl, Math.max(lres.mzpl, Math.max(fzpl, bzpl) ) );
        
        return new ZigZag(fzpl, bzpl, mzpl);
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

        System.out.println(longestZigZagPath(root));
    }

    public static void main(String[] args) {
        solve();
    }
}