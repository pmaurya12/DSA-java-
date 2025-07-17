
import java.util.*;
public class binarytree {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    static class BinaryTree{
        static int idx=-1;
        public static Node buildTree(int nodes[]){
            idx++;
            if(nodes[idx]==-1){
                return null;
            }
            Node newNode=new Node(nodes[idx]);
            newNode.left=buildTree(nodes);
            newNode.right=buildTree(nodes);
            return newNode;
        }
        public static void preorder(Node root){
            if(root==null){
                // System.out.print("-1 ");
                return ;
            }
            System.out.print(root.data+" ");
            preorder(root.left);
            preorder(root.right);
        }
        public static void inorder(Node root){
            if(root==null){
                // System.out.print("-1 ");
                return;
            }
            inorder(root.left);
            System.out.print(root.data+" ");
            inorder(root.right);
        }
        public static void postorder(Node root){
            if(root==null){
                // System.out.print("-1 ");
                return;
            }
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data+" ");
        }
        public static void levelOrder(Node root){
            if(root==null){
                return;
            }
            Queue<Node> q=new LinkedList<>();
            q.add(root);
            q.add(null);
            while(!q.isEmpty()){
                Node currNode=q.remove();
                if(currNode==null){
                    System.out.println();
                    if(q.isEmpty()){
                        break;
                    }
                    else{
                        q.add(null);
                    }
                }
                else{
                    System.out.print(currNode.data+" ");
                    if(currNode.left!=null){
                        q.add(currNode.left);
                    }
                    if(currNode.right!=null){
                        q.add(currNode.right);
                    }
                }
            } 
        }
        public static int height(Node root){
            if(root==null){
                return 0;
            }
            int lh=height(root.left);
            int rh=height(root.right);
            return Math.max(rh,lh)+1;
        }
        public static int count(Node root){
            if(root==null){
                return 0;
            }
            int lcount=count(root.left);
            int rcount=count(root.right);
            return lcount+rcount+1;
        }
        public static int sum(Node root){
            if(root==null){
                return 0;
            }
            int lsum=sum(root.left);
            int rsum=sum(root.right);
            return lsum+rsum+root.data;
        }
        public static int diameter(Node root){
            if(root==null){
                return 0;
            }
            int leftdiam=diameter(root.left);
            int rightdiam=diameter(root.right);
            int leftheight=height(root.left);
            int rightheight=height(root.right);
            int self=leftheight+rightheight+1;
            return Math.max(Math.max(leftdiam,rightdiam),self);
        }
        public static class Info{
            int diam;
            int ht;
            public Info(int diam,int ht){
                this.diam=diam;
                this.ht=ht;
            }
        }
        public static Info diameter2(Node root){
            if(root==null){
                return new Info(0,0);
            }
            Info leftInfo=diameter2(root.left);
            Info rightInfo=diameter2(root.right);
            int diam=Math.max(leftInfo.diam,Math.max(rightInfo.diam,leftInfo.ht+rightInfo.ht+1));
            int ht=Math.max(leftInfo.ht,rightInfo.ht)+1;
            return new Info(diam,ht);
        }
        public static boolean isIdentical(Node node,Node subRoot){
            if(node==null && subRoot==null){
                return true;
            }
            else if(node==null || subRoot==null || node.data!=subRoot.data){
                return false;
            }
            if(!isIdentical(node.left,subRoot.left)){
                return false;
            }
            if(!isIdentical(node.right, subRoot.right)){
                return false;
            }
            return true;
        }

        public static boolean isSubtree(Node root,Node subRoot){
            if(root==null){
                return false;
            }
            if(root.data==subRoot.data){
                if(isIdentical(root,subRoot)){
                    return true;
                }
            }
            boolean leftAns=isSubtree(root.left,subRoot);
            boolean rightAns=isSubtree(root.right,subRoot);
            return leftAns || rightAns;
        }
        static class Info2{
            Node node;
            int hd;
            public Info2(Node node,int hd){
                this.node=node;
                this.hd=hd;
            }
        }
        public static void topView(Node root){
            Queue<Info2> q=new LinkedList<>();
            HashMap<Integer,Node>map=new HashMap<>();
            int min=0,max=0;
            q.add(new Info2((root),0));
            q.add(null);
            while(!q.isEmpty()){
                Info2 curr=q.remove();
                if(curr==null){
                    if(q.isEmpty()){
                        break; 
                    }
                    else{
                        q.add(null); 
                    }
                }
                else{
                if(!map.containsKey(curr.hd)){
                    map.put(curr.hd,curr.node);
                }
                if(curr.node.left!=null){
                    q.add(new Info2(curr.node.left,curr.hd-1));
                    min=Math.min(min,curr.hd-1);
                }
                if(curr.node.right!=null){
                    q.add(new Info2(curr.node.right,curr.hd+1));
                    max=Math.max(max,curr.hd+1);
                }
                }
            }
            for(int i=min;i<=max;i++){
                System.out.print(map.get(i).data+" ");
            }
            System.out.println(); 
        }
        public static void kLevel(Node root,int level,int k){
            if(root==null){
                return;
            }
            if(level==k){
                System.out.print(root.data+" ");
                return;
            }
            kLevel(root.left,level+1,k);
            kLevel(root.right,level+1,k);
        }
        public static int lcaDist(Node root,int n){
            if(root==null){
                return -1;
            }
            if(root.data==n){
                return 0; 
            }
            int leftDist=lcaDist(root.left,n);
            int rightDist=lcaDist(root.right,n);
            if(leftDist==-1 && rightDist==-1){
                return -1;
            }
            else if(leftDist==-1){
                return rightDist+1;
            }
            else{
                return leftDist+1;
            }
        }
        public static int kAncestor(Node root,int n,int k){
            if(root==null){
                return -1;
            }
            if(root.data==n){
                return 0;
            }
            int leftDist=kAncestor(root.left, n,k);
            int rightDist=kAncestor(root.right, n,k);
            if(leftDist==-1 && rightDist==-1){
                return -1;
            }
            int max=Math.max(leftDist,rightDist);
            if(max+1==k){
                System.out.println(root.data);
            }
            return max+1;
        }
        public static int transform(Node root){
            if(root==null){
                return 0;
            }
            int leftChild=transform(root.left);
            int rightChild=transform(root.right);
            int data=root.data;
            int newLeft=root.left==null?0:root.left.data;
            int newRight=root.right==null?0:root.right.data;
            root.data=newLeft+leftChild+newRight+rightChild;
            return data;
        }
    }
    public static void main(String[] args) {
        int[] nodes ={1,2,-1,-1,5,-1,-1};
        BinaryTree tree =new BinaryTree();
        Node rooot=tree.buildTree(nodes);
        Node root=new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.right.left=new Node(6);
        root.right.right=new Node(7);
        System.out.println(root.data);
        System.out.print("preorder ");
        tree.preorder(root);
        System.out.print("inorder ");
        tree.inorder(root);
        System.out.print("postorder ");
        tree.postorder(root);
        System.out.println();
        System.out.print("levelorder");
        System.out.println();
        tree.levelOrder(root);
        System.out.println(tree.height(root));
        System.out.println(tree.count(root));
        System.out.println(tree.sum(root));
        System.out.println(tree.diameter(root));
        System.out.println(tree.diameter2(root).diam);
        Node subRoot=new Node(2);
        subRoot.left=new Node(4);
        subRoot.right=new Node(5);
        System.out.println(tree.isSubtree(root,subRoot));
        tree.topView(root);
        tree.kLevel(root,1,3);
        System.out.println("hehehe");
        System.out.println(tree.lcaDist(root,3));
        tree.kAncestor(root,5,2);
        tree.transform(root);
        tree.preorder(root);
    }
}
