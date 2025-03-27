import java.util.*;

public class tree{
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
                    return;
               }
               System.out.print(root.data+" ");
               preorder(root.left);
               preorder(root.right);
          }
          public static void inorder(Node root){
               if(root==null){
                    return;
               }
               preorder(root.left);
               System.out.print(root.data+" ");
               preorder(root.right);
          }
          public static void postorder(Node root){
               if(root==null){
                    return;
               }
               preorder(root.left);
               preorder(root.right);
               System.out.print(root.data+" ");
          }
          public static void levelorder(Node root){
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
                         }else{
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
               int left=height(root.left);
               int right=height(root.right);
               int height=Math.max(left, right)+1;

               return height;
          }
          public static int countNodes(Node root){
               if(root==null){
                    return 0;
               }
               int lcount=countNodes(root.left);
               int rcount=countNodes(root.right);

               return lcount+rcount+1;
          }
          public static int sum(Node root){
               if(root==null){
                    return 0;
               }
               int lsum=sum(root.left);
               int rsum=sum(root.right);
               int sum=lsum+rsum+root.data;

               return sum;
          }
     }
     public static void main(String[] args) {
          int nodes[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
          BinaryTree tree=new BinaryTree();
          Node root=tree.buildTree(nodes);
          
          tree.levelorder(root);
          System.out.println("Height: "+tree.height(root));
          System.out.println("No. of nodes: "+tree.countNodes(root));
          System.out.println("Sum: "+tree.sum(root));
     }
}
