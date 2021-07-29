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
    
    private static int bstIdx;
    public static TreeNode bstFromPostorder(int[] postorder, int lp, int rp ){
        if( bstIdx < 0 || postorder[bstIdx] < lp || postorder[bstIdx] >rp ){
            return null;
        }
        
        int val = postorder[bstIdx--];
        TreeNode node = new TreeNode(val);
        
        node.right = bstFromPostorder(postorder, val, rp);
        node.left = bstFromPostorder(postorder, lp, val);
        
        return node;
        
        
        
    }
    public static TreeNode bstFromPostorder(int[] postorder) {
        bstIdx = postorder.length - 1;
        
        return bstFromPostorder(postorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    // input_section=================================================

    public static void display(TreeNode node) {
        if (node == null)
            return;

        StringBuilder sb = new StringBuilder();
        sb.append((node.left != null ? node.left.val : "."));
        sb.append(" -> " + node.val + " <- ");
        sb.append((node.right != null ? node.right.val : "."));

        System.out.println(sb.toString());

        display(node.left);
        display(node.right);

    }


    

    public static void solve() {
        int n = scn.nextInt();
        int[] pre = new int[n];
        for (int i = 0; i < n; i++)
            pre[i] = scn.nextInt();

        TreeNode root = bstFromPostorder(pre);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}