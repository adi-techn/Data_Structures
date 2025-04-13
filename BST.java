import java.util.*;

public class BST {
     static class TreeNode{
          int val;
          TreeNode left;
          TreeNode right;

          TreeNode(int val){
               this.val=val;
          }
     }
     public static TreeNode buildBST(TreeNode root,int val){
          if(root==null){
               root=new TreeNode(val);
               return root;
          }
          if(root.val>val){
               root.left=buildBST(root.left, val);
          }
          else{
               root.right=buildBST(root.right, val);
          }
          return root;
     }
     public static boolean search(TreeNode root,int val){
          if(root==null){
               return false;
          }
          if(root.val==val){
               return true;
          }
          if(val<root.val){
               return search(root.left, val);
          }
          else{
               return search(root.right, val);
          }
     }
     public static void inorder(TreeNode root){
          if(root==null){
               return;
          }
          inorder(root.left);
          System.out.print(root.val+" ");
          inorder(root.right);
     }
     public static TreeNode delete(TreeNode root,int val){
          if(root.val<val){
               root.right=delete(root.right, val);
          }
          else if(root.val>val){
               root.left=delete(root.left, val);
          }
          else{
               //case-1:leaf node
               if(root.left==null && root.right==null){
                    return null;
               }
               //case-2: one child
               if(root.left==null){
                    return root.right;  
               }
               else if(root.right==null){
                    return root.left;
               }
               //case-3: both left & right child
               TreeNode IS=inorderSuccessor(root.right);
               root.val=IS.val;
               root.right=delete(root.right,IS.val);
          }
          return root;
     }
     public static TreeNode inorderSuccessor(TreeNode root){
          while(root.left!=null){
               root=root.left;
          }
          return root;
     }
     public static void printRange(TreeNode root,int k1,int k2){
          if(root==null){
               return;
          }
          if(k1<=root.val && root.val<=k2){
               printRange(root.left, k1, k2);
               System.out.print(root.val +" ");
               printRange(root.right, k1, k2);
          }
          else if(root.val<k2){
               printRange(root.left, k1, k2);
          }
          else{
               printRange(root.right, k1, k2);
          }
     }
     public static void print(ArrayList<Integer> arr){
          for(int i=0;i<arr.size();i++){
               System.out.print(arr.get(i)+"->");
          }
          System.out.println("Null");
          
     }
     public static void printPath(TreeNode root,ArrayList<Integer> arr){
          if(root==null){
               return;
          }
          arr.add(root.val);
          if(root.left==null && root.right==null){
               print(arr);
          }
          printPath(root.left, arr);
          printPath(root.right, arr);
          arr.remove(arr.size()-1);
     }
     public static boolean isValidBST(TreeNode root,TreeNode min,TreeNode max){
          if(root==null){
               return true;
          }
          if(min!=null && root.val<=min.val){
               return false;
          }
          if(max!=null && root.val>=max.val){
               return false;
          }
          return isValidBST(root.left, min,root) && isValidBST(root.right,root, max);
     }
     public static TreeNode mirror(TreeNode root){
          if(root==null){
               return null;
          }
          TreeNode lsub=mirror(root.left);
          TreeNode rsub=mirror(root.right);

          root.left=rsub;
          root.right=lsub;

          return root;
     }
     public static void main(String[] args) {
          int values[]={8,5,3,1,4,6,10,11,14};
          TreeNode root=null;

          for(int i=0;i<values.length;i++){
               root=buildBST(root,values[i]);
          }
          inorder(root);
          System.out.println();

          inorder(mirror(root));
          
     }
}
