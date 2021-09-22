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
    public void flatten(TreeNode root) {
        flattenHelper(root);
    }
    public TreeNode flattenHelper(TreeNode node){
        if( node == null ){
            return null;
        }
        TreeNode leftTail = flattenHelper(node.left);
        TreeNode rightTail = flattenHelper(node.right);
        
        if( leftTail == null && rightTail == null ){
            return node;
        }
        if( node.left != null && node.right == null ){
            node.right = node.left;
            node.left = null;
            return leftTail;
        }
        if( node.left != null && node.right != null ){
            leftTail.right = node.right;
            node.right = node.left;
            node.left = null;
        }
        return rightTail;
    }
}