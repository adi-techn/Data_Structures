import java.util.*;
public class nextGreater {
     public static void nextGreat(int arr[]){
          Stack<Integer> s=new Stack<>();
          int nextG[]=new int[arr.length];
          for(int i=arr.length-1;i>=0;i--){
               //Step-1
               while(!s.isEmpty() && arr[s.peek()]<=arr[i]){
                    s.pop();
               }
               //Step-2
               if(s.isEmpty()){
                    nextG[i]=-1;
               }
               else{
                    nextG[i]=arr[s.peek()];
               }
               //Step-3
               s.push(i);
          }
          for(int i=0;i<nextG.length;i++){
               System.out.print(nextG[i]+", ");
          }
     }
     public static void main(String[] args) {
          int arr[]={6,8,0,1,3};
          nextGreat(arr);
     }
}
