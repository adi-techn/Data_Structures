public class SegmentTree {
     static int tree[];
     public static void init(int n){
          tree=new int[4*n];
     }
     public static int buildST(int arr[],int i,int st,int end){
          if(st==end){
               tree[i]=arr[st];
               return arr[st];
          }
          int mid=(st+end)/2;
          buildST(arr, 2*i+1, st, mid);
          buildST(arr, 2*i+2, mid+1, end);
          tree[i]=tree[2*i+1]+tree[2*i+2];
          return tree[i];
     }
     public static int sumQueryUtil(int i,int si,int sj,int qi,int qj){
          if(qj<=si || sj<=qi){  //Non-overlapping
               return 0;
          }else if(qi<=si && qj>=sj){  //Complete overlapping
               return tree[i];
          }else{                      //Partial Overlapping
               int mid=(si+sj)/2;
               int left=sumQueryUtil(2*i+1, si, mid, qi, qj);
               int right=sumQueryUtil(2*i+2, mid+1, sj, qi, qj);
               return left + right;
          }
     }
     public static int sumQuery(int arr[],int qi,int qj){
          int n=arr.length;
          return sumQueryUtil(0, 0, n-1, qi, qj);
     }
     public static void update(int arr[],int idx,int newVal){
          int diff=newVal-arr[idx];
          arr[idx]=newVal;
          updateST(0,0,arr.length,idx,diff);
     }
     public static void updateST(int i,int si, int sj, int idx,int diff){
          if(idx>sj || idx<si){
               return;
          }
          tree[i]+=diff;
          if(si != sj){
               int mid=(si+sj)/2;
               updateST(2*i+1, si, mid, idx, diff);
               updateST(2*i+2, mid+1, sj, idx, diff);
          }
          return;
     }
     public static void main(String[] args) {
          int arr[]={1,2,3,4,5,6,7,8};
          int n=arr.length;
          init(n);
          buildST(arr, 0, 0, n-1);

          for(int x:tree){
               System.out.print(x+" ");
          }System.out.println();

          System.out.println(sumQuery(arr, 2, 5));

          update(arr, 2, 2);
          for(int x:tree){
               System.out.print(x+" ");
          }
     }
}
