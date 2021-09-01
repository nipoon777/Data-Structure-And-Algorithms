/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        
        serializeHelper(root, sb);
        
        return sb.toString();
        
    }
    public void serializeHelper(TreeNode root, StringBuilder sb){
        if( root == null ){
            sb.append("null,");
            return;
        }
        sb.append(root.val + ",");
        serializeHelper(root.left, sb);
        serializeHelper(root.right, sb);
    }
    
     class Pair{
        TreeNode node;
        int state;
        Pair(TreeNode node, int state){
            this.node = node;
            this.state = state;
        }
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strArr = data.split(",");
        if( !strArr[0].equals("null") ){
            TreeNode root = new TreeNode(Integer.parseInt(strArr[0]));

            Stack <Pair> st = new Stack<>();

            st.push(new Pair(root, -1));
            int idx = 1;

            while( st.size() > 0 ){
                Pair top = st.peek();
                if( top.state == -1 ){
                    if( !strArr[idx].equals("null") ){
                        TreeNode newNode = new TreeNode(Integer.parseInt(strArr[idx]));
                        top.node.left = newNode;
                        st.push(new Pair(newNode, -1));
                    }
                    top.state++;
                    idx++;
                }else if( top.state == 0){
                    if( !strArr[idx].equals("null") ){
                        TreeNode newNode = new TreeNode(Integer.parseInt(strArr[idx]));
                        top.node.right = newNode;
                        st.push(new Pair(newNode, -1));
                    }
                    top.state++;
                    idx++;
                }else{
                    st.pop();
                }
            }  
            return root;
        }else{
            return null;
        }
        
        
        }
    
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));