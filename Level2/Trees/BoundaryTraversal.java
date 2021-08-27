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
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        
        List<Integer> res = new ArrayList<>();
        if( root.left == null && root.right == null ){
            res.add(root.val);
            return res;
        }
        if( root.left == null ){
            res.add(root.val);
        }else{
            getLeftBoundary(root, res);
        }
        
        getLeaves(root, res);
        getRightBoundary(root.right, res);
        
        return res;
    }
    
    public void getLeftBoundary(TreeNode root, List<Integer> res){
        if( root == null ){
            return;
        }
        if( root.left != null ){
            res.add(root.val);
            getLeftBoundary(root.left, res);
        }else if( root.right != null ){
            res.add(root.val);
            getLeftBoundary(root.right, res);
        }
    }
    public void getLeaves(TreeNode node, List<Integer> res){
        if( node == null ){
            return;
        }
        if( node.left == null && node.right == null ){
            res.add(node.val);
            return;
        }
        getLeaves(node.left, res);
        getLeaves(node.right, res);
    }
    
    public void getRightBoundary(TreeNode node, List <Integer> res){
        if( node == null ){
            return;
        }
        if( node.right != null ){
            getRightBoundary(node.right, res);
            res.add(node.val);
        }else if( node.left != null){
            getRightBoundary(node.left, res);
            res.add(node.val);
        }
    }
}