// { Driver Code Starts
    import java.io.*;
    import java.util.*;
    
    public class pair
    {
        int first;
        boolean second;
        pair(int first, boolean second)
            {
                this.first = first;
                this.second = second;
            }
    }
    class Node
    {
        int data, height;
        Node left, right;
        
        Node(int x)
        {
            data=x;
            left=right=null;
            height=1;
        }
    }
    class GfG
    {
        public static boolean isBST(Node n, int lower, int upper)
        {
            if(n==null) return true;
            if( n.data <= lower || n.data >= upper ) return false;
            return isBST(n.left, lower, n.data) && isBST(n.right, n.data, upper) ;
        }
        
        public static pair isBalanced(Node n)
        {
            if(n==null)
                {
                    return new pair(0,true);
                }
            
            pair l = isBalanced(n.left);
            pair r = isBalanced(n.right);
        
            if( Math.abs(l.first - r.first) > 1 ) return new pair (0,false);
        
            return new pair( 1 + Math.max(l.first , r.first) , l.second && r.second );
        }
        
        public static boolean isBalancedBST(Node root)
        {
            if( isBST(root, Integer.MIN_VALUE , Integer.MAX_VALUE) == false )
                System.out.print("BST voilated, inorder traversal : ");
        
            else if ( isBalanced(root).second == false)
                System.out.print("Unbalanced BST, inorder traversal : ");
        
            else return true;
            return false;
        }
        
        public static void printInorder(Node n)
        {
            if(n==null) return;
            printInorder(n.left);
            System.out.print(n.data + " ");
            printInorder(n.right);
        }
    
    
        public static void main(String args[])
            {
                int ip[] = new int[2000];
                Scanner sc = new Scanner(System.in);
                int t = sc.nextInt();
                while(t-->0)
                    {
                        int n = sc.nextInt();
                        for(int i = 0; i < n; i++)
                            {
                                ip[i] = sc.nextInt();
                            }
                            
                        Node root = null;
                        Solution obj = new Solution();
                        for(int i=0; i<n; i++)
                        {
                            root = obj.insertToAVL( root, ip[i] );
                            
                            if ( isBalancedBST(root) == false )
                                break;
                        }
                        
                        printInorder(root);
                        System.out.println();
                        
                    }
                
                    
            }
    }// } Driver Code Ends
    
    
    //User function Template for Java
    
    /*
    class Node
    {
        int data;
        Node left;
        Node right;
        int height;
    };
    */
    class Solution
    {
        public  Node insertToAVL(Node node,int data)
        {
            if( node == null ){
                return new Node(data);
            }
            if( data < node.data ){
                node.left = insertToAVL(node.left, data);
            }else if( data > node.data ){
                node.right = insertToAVL(node.right, data);
            }
            int lht = height(node.left), rht = height(node.right);
            node.height = Math.max(lht, rht) + 1;
            int diff = height(node.left) - height(node.right);
            Node newNode = node;
            if( diff > 1){
                if( data > node.left.data ){//LR
                    node.left = rotateLeft(node.left);
                    newNode = rotateRight(node);
                    
                }else{//LL
                    newNode = rotateRight(node);
                }
            }else if( diff < -1 ){
                if( data < node.right.data){//RL
                    node.right = rotateRight(node.right);
                    newNode = rotateLeft(node);
                    
                }else{//RR Problem
                    newNode = rotateLeft(node);
                }
            }
            return newNode;
        }
        public Node rotateRight(Node node){
            Node a = node;
            Node b = node.left;
            Node T2 = b.right;
            
            b.right = a;
            a.left = T2;
            
            a.height = Math.max(height(a.left), height(a.right)) + 1;
            b.height = Math.max(height(b.left), height(b.right)) + 1;
            
            return b;
        }
        public Node rotateLeft(Node node){
            Node a = node;
            Node b = node.right;
            
            Node T2 = b.left;
            
            b.left = a;
            a.right = T2;
            
            a.height = Math.max(height(a.left), height(a.right)) + 1;
            b.height = Math.max(height(b.left), height(b.right)) + 1;
            
            return b;
            
            
            
        }
        public int height(Node node){
            if( node == null ){
                return 0;
            }else{
                return node.height;
            }
        }
    }    