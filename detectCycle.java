public class detectCycle{            //Floyd's Cycle Detection Algo
     public static class Node{
          int val;
          Node next;

          public Node(int val){
               this.val=val;
               this.next=null;
          }
     }
     public static Node head;
     public static boolean isCycle() {
          if(head==null||head.next==null){
               return false;
          }
          Node fast=head;
          Node slow=head;

          while(fast!=null && fast.next!=null){
               slow=slow.next;
               fast=fast.next.next;
               if(fast==slow){
                    return true;
               }
          }
          return false;
     }
     public static void removeCycle(){
          //Detecting Cycle
          Node fast=head,slow=head;
          boolean d=false;
          while(fast.next!=null && fast!=null){
               slow=slow.next;
               fast=fast.next.next;
               if(fast==slow){
                    d=true;
                    break;
               }
          }
          //Find meeting point
          if(d==true){
               slow=head;
               Node prev=null;
               while(fast!=slow){
                    slow=slow.next;
                    prev=fast;
                    fast=fast.next;
               }
               prev.next=null;          //Breaking the cycle
               System.out.print("Cycle broken.");
          }
          else{
               System.out.println("No Cycle");
          }
     }
     public static void main(String[] args) {
          head =new Node(1);
          head.next=new Node(2);
          Node temp=new Node(5);
          head.next.next=temp;
          head.next.next.next=new Node(6);
          head.next.next.next.next=temp;

          System.out.println(isCycle());
          removeCycle();
     }
}



