public class stackLL {
     static class Node{
          int val;
          Node next;
          Node(int data){
               this.val=data;
               this.next=null;
          }
     }
     static class Stack{
          static Node head=null;
          public static boolean isEmpty(){
               return head==null;
          }
          public static void push(int val){
               Node newNode=new Node(val);
               if(isEmpty()){
                    head=newNode;
                    return;
               }
               newNode.next=head;
               head=newNode;
          }
          public static int pop(){
               if(isEmpty()){
                    return -1;
               }
               int top=head.val;
               head=head.next;
               return top;
          }
          public static int peek(){
               if(isEmpty()){
                    return -1;
               }
               return head.val;
          }
     }
     public static void main(String[] args) {
          Stack s=new Stack();
          s.push(3);
          s.push(2);
          s.push(1);

          while(!s.isEmpty()){
               System.out.println(s.pop());
          }
     }
}
