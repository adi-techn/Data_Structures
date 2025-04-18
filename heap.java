import java.util.ArrayList;

public class heap {
     static class Heap{
          ArrayList<Integer> arr=new ArrayList<>();

          public void add(int val){
               arr.add(val);      //add at last idx

               int i=arr.size()-1;  //Child idx
               int par=(i-1)/2;     //Parent idx

               while(arr.get(i)<arr.get(par)){
                    //swap val of child & parent
                    int temp=arr.get(i);
                    arr.set(i, arr.get(par));
                    arr.set(par,temp);

                    i=par;
                    par=(i-1)/2;
               }
          }
          public int peek(){
               return arr.get(0);
          }
          public int remove(){
               int val=arr.get(0);

               //Step-1 : Swap root with last idx
               int temp=arr.get(0);
               arr.set(0,arr.get(arr.size()-1));
               arr.set(arr.size()-1,temp);

               //Step-2 : Delete last idx value
               arr.remove(arr.size()-1);

               //Step-3 : Heapify
               Heapify(0);

               return val;
          }
          public void Heapify(int i){
               int left=2*i+1;
               int right=2*i+2;
               int minIdx=i;

               if(left<arr.size() && arr.get(minIdx)>arr.get(left)){
                    minIdx=left;
               }
               if(right<arr.size() && arr.get(minIdx)>arr.get(right)){
                    minIdx=right;
               }
               if(minIdx!=i){
                    //Swap
                    int temp=arr.get(i);
                    arr.set(i,arr.get(minIdx));
                    arr.set(minIdx,temp);

                    Heapify(minIdx);
               }
          }
          public boolean isEmpty(){
               return arr.size()==0;
          }
     }
     public static void main(String[] args) {
          Heap pq=new Heap();
          pq.add(3);
          pq.add(4);
          pq.add(1);
          pq.add(5);

          while (!pq.isEmpty()) {
               System.out.println(pq.peek());
               pq.remove();
          }
     }
}
