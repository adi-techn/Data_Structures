public class maxST {
     static int tree[];
     public static void init(int n){
          tree=new int[n*4];
     }
     public static void buildMaxST(int i,int si,int sj,int arr[]){
          if(si==sj){
               tree[i]=arr[si];
               return;
          }
          int mid=(si+sj)/2;
          buildMaxST(2*i+1,si,mid,arr);
          buildMaxST(2*i+2,mid+1,sj,arr);

          tree[i]=Math.max(tree[2*i+1],tree[2*i+2]);
     }
     public static int getMax(int arr[],int qi,int qj){
          int n=arr.length;
          return getMaxUtil(0,0,n-1,qi,qj);
     }
     public static int getMaxUtil(int i,int si,int sj,int qi,int qj){
          if(sj<qi || si>qj){
               return Integer.MIN_VALUE;
          }else if(si>=qi && sj<=qj){
               return tree[i];
          }else{
               int mid=(si+sj)/2;
               int leftans=getMaxUtil(2*i+1, si, mid, qi, qj);
               int rightans=getMaxUtil(2*i+2, mid+1, sj, qi, qj);
               return Math.max(leftans, rightans);
          }
     }
     public static void main(String[] args) {
          int arr[]={6,8,-1,2,17,1,3,2,4};
          int n=arr.length;

          init(n);
          buildMaxST(0,0,n-1,arr);
          for(int x:tree){
               System.out.print(x+" ");
          }System.out.println();
          System.out.println("Max value between range: "+getMax(arr, 2, 5));
     }
}
