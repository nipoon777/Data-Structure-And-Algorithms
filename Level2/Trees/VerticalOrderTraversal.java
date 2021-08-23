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
    public static ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode root) {
        
        Queue <Pair> mq = new ArrayDeque<>();
        mq.add(new Pair(root, 0));
        HashMap< Integer, ArrayList<Integer> > hm = new HashMap<>();
        while( mq.size() > 0 ){
            Pair front = mq.remove();
            if( hm.containsKey(front.state) ){
                ArrayList<Integer> list = hm.get(front.state);
                list.add(front.node.val);
                hm.put(front.state, list);
            }else{
                ArrayList<Integer> list = new ArrayList<>();
                list.add(front.node.val);
                hm.put(front.state, list);
            }
            
            if(front.node.left != null ){
                mq.add(new Pair(front.node.left, front.state - 1));
            }
            if(front.node.right != null ){
                mq.add(new Pair(front.node.right, front.state + 1));
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
        
        ArrayList<ArrayList<Integer> > res = new ArrayList<>();
        
        
        for(int i = min ; i <= max ; i++ ){
            res.add( hm.get(i) );
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

        ArrayList<ArrayList<Integer>> ans = verticalOrderTraversal(root);
        int idx = 0;
        for (ArrayList<Integer> i : ans) {
            System.out.print(idx++ + " -> ");
            for (Integer j : i)
                System.out.print(j + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        solve();
    }
}