public class minDist {
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
     public static Node lca(Node root,int n1,int n2){
          if(root==null || root.data==n1 || root.data==n2){
               return root;
          }

          Node left=lca(root.left, n1, n2);
          Node right=lca(root.right, n1, n2);

          if(left==null){
               return right;
          }
          if(right==null){
               return left;
          }
          return root;
     }
     public static int lcaDist(Node root,int n){
          if(root==null){
               return -1;
          }
          if(root.data==n){
               return 0;
          }
          
          int leftDist=lcaDist(root.left, n);
          int rightDist=lcaDist(root.right, n);

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
     public static int minDist(Node root,int n1,int n2){
          Node lca=lca(root, n1, n2);
          int n1_dist=lcaDist(root,n1);
          int n2_dist=lcaDist(root,n2);

          return n1_dist + n2_dist;
     }
     public static void main(String[] args) {
          Node root=new Node(1);
          root.left=new Node(2);
          root.left.left=new Node(4);
          root.left.right=new Node(5);
          root.right=new Node(6);
          root.right.right=new Node(7);

          System.out.println(minDist(root, 2, 6));
     }
}
