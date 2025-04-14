public class SortedArrBST {
     static class TreeNode{
          int val;
          TreeNode left;
          TreeNode right;

          TreeNode(int val){
               this.val=val;
          }
     }
     public static TreeNode createBST(int arr[],int st,int end){
          if(st>end){
               return null;
          }
          int mid=(st+end)/2;
          TreeNode root=new TreeNode(arr[mid]);

          root.left=createBST(arr, st,mid-1);
          root.right=createBST(arr,mid+1, end);

          return root;
     }
     public static void preorder(TreeNode root){
          if(root==null){
               return;
          }
          System.out.print(root.val+" ");
          preorder(root.left);
          preorder(root.right);
     }
     public static void main(String[] args) {
          int arr[]={3,5,6,8,10,11,12};
          preorder(createBST(arr,0,arr.length-1));

     }
}
