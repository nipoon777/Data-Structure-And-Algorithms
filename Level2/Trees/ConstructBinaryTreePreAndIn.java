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
    public static TreeNode buildTree(int[] preorder, int psi, int pei, int[] inorder, int isi, int iei ){
        if( psi > pei ){
            return null;
        }
        int val = preorder[psi];
        //Iska abhi Node banao;
        
        TreeNode node = new TreeNode(val);
        // Abhi Left aur right ke liye unke boundaries decide karne padenge
        int idx = isi;
        
        while( inorder[idx] != val ){
            idx++;
        }
        int tnel = idx - isi;
        
        node.left = buildTree(preorder, psi + 1, psi + tnel, inorder, isi, idx - 1);
        node.right = buildTree( preorder, psi + tnel + 1, pei, inorder, idx + 1, iei);
        
        return node;
    }
    

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
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

        int[] in = new int[n];
        for (int i = 0; i < n; i++)
            in[i] = scn.nextInt();

        TreeNode root = buildTree(pre, in);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}