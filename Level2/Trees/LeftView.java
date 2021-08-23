import java.util.*;

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

    public static ArrayList<Integer> leftView(TreeNode root) {
        ArrayList<Integer> leftView = new ArrayList<>();
        
        Queue<TreeNode> mq = new ArrayDeque<>();
        Queue<TreeNode> hq = new ArrayDeque<>();
        
        mq.add(root);
        leftView.add(root.val);
        
        
        while( mq.size() > 0 ){
            TreeNode front = mq.remove();
            
            if( front.left != null ){
                hq.add(front.left);
            }
            if( front.right != null ){
                hq.add(front.right);
            }
            
            if( mq.size() == 0){
                if(hq.size() > 0 ){
                    
                    leftView.add(hq.peek().val );
                }
                mq = hq;
                hq = new ArrayDeque();
            }
        }
        return leftView;
    }

    // input_section=================================================

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

        ArrayList<Integer> ans = leftView(root);
        for(Integer i : ans) System.out.println(i); 
    }

    public static void main(String[] args) {
        solve();
    }
}