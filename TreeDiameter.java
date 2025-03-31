public class TreeDiameter{
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
          public static int height(Node root){
               if(root==null){
                    return 0;
               }
               int left=height(root.left);
               int right=height(root.right);
               
               return Math.max(left,right)+1;
          }
          // T.C. = O(n^2) 
          public static int diameter(Node root){
               if(root==null){
                    return 0;
               }
               int l_dia=diameter(root.left);
               int r_dia=diameter(root.right);
               int lh=height(root.left);
               int rh=height(root.right);

               int selfDia=l_dia+r_dia+1;

               return Math.max(selfDia,Math.max(l_dia,r_dia));
          }
     }
     static class Info{
          int dia;
          int ht;
          Info(int dia,int ht){
               this.dia=dia;
               this.ht=ht;
          }
     }
     public static Info diameterInfo(Node root){
          if(root==null){
               return new Info(0, 0);
          }
          Info leftInfo=diameterInfo(root.left);
          Info rightInfo=diameterInfo(root.right);

          int dia=Math.max(Math.max(leftInfo.dia,rightInfo.dia),leftInfo.ht+rightInfo.ht+1);
          int ht=Math.max(leftInfo.ht,rightInfo.ht)+1;

          return new Info(dia, ht);
     }
     public static void main(String[] args) {
          int nodes[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
          BinaryTree tree=new BinaryTree();
          Node root=tree.buildTree(nodes);
          System.out.println("Height: "+diameterInfo(root).ht);
          System.out.println("Diameter: "+diameterInfo(root).dia);
     }    
}
