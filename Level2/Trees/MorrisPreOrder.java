/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        
        while( root != null ){
            if( root.left != null ){
                TreeNode rootp = root.left;
                while( rootp.right != null && rootp.right != root ){
                    rootp = rootp.right;
                }
                if( rootp.right == root){
                    rootp.right = null;
                    root = root.right;
                }else{
                    res.add(root.val);
                    rootp.right = root;
                    root = root.left;
                }
            }else{
                res.add(root.val);
                root = root.right;
            }
        }
        return res;
        
    }
}