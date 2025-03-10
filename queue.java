import java.util.*;
public class queue{
     static class QueueArr{
          static int arr[];
          static int size;
          static int rear;

          QueueArr(int n){
               arr=new int[n];
               size=n;
               rear=-1;
          }

          public static boolean isEmpty(){
               return rear==-1;
          }
          public static void add(int data){
               if(rear==size-1){
                    System.out.println("Full");
                    return;
               }
               rear++;
               arr[rear]=data;
          }
          public static int remove(){
               if(isEmpty()){
                    System.out.println("Empty queue");
                    return -1;
               }
               int front=arr[0];
               for(int i=0;i<rear;i++)
                    arr[i]=arr[i+1];
               rear--;
               return front;
          }
          public static int peek(){
               if(isEmpty()){
                    System.out.println("Empty");
                    return -1;
               }
               return arr[0];
          }
     }
     static class ListNode{
          int val;
          ListNode next;

          ListNode(int val){
               this.val=val;
               this.next=null;
          }
     }
     static class QueueLL{
          static ListNode head=null;
          static ListNode tail=null;
          public static boolean isEmpty(){
               return head==null && tail==null;
          }
          public static void add(int data){
               ListNode newNode=new ListNode(data);
               if(head==null){
                    head=tail=newNode;
                    return;
               }
               tail.next=newNode;
               tail=newNode;
          }
          public static int remove(){
               if(isEmpty()){
                    System.out.println("Empty queue");
                    return -1;
               }
               int front=head.val;
               if(head==tail){
                    head=tail=null;
               }
               else{
                    head=head.next;
               }
               return front;
          }
          public static int peek(){
               if(isEmpty()){
                    System.out.println("Empty");
                    return -1;
               }
               return head.val;
          }
     }
     public static void main(String[] args) {
          // Queue<Integer> q=new LinkedList<>();
          QueueLL q=new QueueLL();
          q.add(1);
          q.add(2);
          q.add(3);

          while(!q.isEmpty()){
               System.out.println(q.peek());
               q.remove();
          }
     }
}
