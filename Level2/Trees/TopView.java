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
    public static class Pair{
        TreeNode node;
        int state;
        Pair(TreeNode node, int state){
            this.node = node;
            this.state = state;
        }
    }

    public static ArrayList<Integer> TopView(TreeNode root) {
        Queue <Pair> mq = new ArrayDeque<>();
        HashMap<Integer, Integer> hm = new HashMap<>();
        mq.add( new Pair(root, 0) );
        
        while(mq.size() > 0 ){
            Pair front = mq.remove();
            if( !hm.containsKey(front.state) ){
                hm.put(front.state, front.node.val);
            }
            
            if( front.node.left != null ){
                mq.add(new Pair(front.node.left, front.state - 1) );
            }
            if( front.node.right != null ){
                mq.add(new Pair(front.node.right, front.state + 1) );
            }
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for(int key : hm.keySet() ){
            if( key < min ){
                min = key;
            }
            if( key > max){
                max = key;
            }
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        
        for(int i = min ; i <= max ; i++){
            res.add(hm.get(i));
        }
        return res;

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

        ArrayList<Integer> ans = TopView(root);
        for (Integer i : ans)
            System.out.print(i + " ");

    }

    public static void main(String[] args) {
        solve();
    }
}