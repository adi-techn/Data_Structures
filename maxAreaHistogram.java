import java.util.Stack;

public class maxAreaHistogram {
     public static int maxArea(int arr[]){      //T.C. = O(n)
          int max=0;
          int nsr[]=new int[arr.length];
          int nsl[]=new int[arr.length];

          //Next Smaller Right
          Stack<Integer> s=new Stack<>();
          for(int i=arr.length-1;i>=0;i--){
               while(!s.isEmpty() && arr[s.peek()]>=arr[i])
                    s.pop();
               if(s.isEmpty()){
                    nsr[i]=arr.length;
               }
               else{
                    nsr[i]=s.peek();
               }
               s.push(i);
          }
          //Next smaller left
          s=new Stack<>();
          for(int i=0;i<arr.length;i++){
               while(!s.isEmpty() && arr[s.peek()]>=arr[i]){
                    s.pop();
               }
               if(s.isEmpty()){
                    nsl[i]=-1;
               }
               else{
                    nsl[i]=s.peek();
               }
               s.push(i);
          }
          //Current area: width=j-i-1(nsr[i]-nsl[i]-1)
          for(int i=0;i<arr.length;i++){
               int height=arr[i];
               int width=nsr[i]-nsl[i]-1;
               int area=height*width;
               if(area>max){
                    max=area;
               }
          } 
          return max;
     }
     public static void main(String[] args) {
          int arr[]={2,4};
          System.out.println(maxArea(arr));
     }
}
