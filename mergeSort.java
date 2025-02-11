public class mergeSort {
     public static class Node{
          int val;
          Node next;

          public Node(int val){
               this.val=val;
               this.next=null;
          }
     }
     public static Node head;

     public void addFirst(int val) {
          Node newNode = new Node(val);
          newNode.next = head;
          head = newNode;
     }
     public void print() {
          Node temp = head;
          while (temp != null) {
               System.out.print(temp.val + " -> ");
               temp = temp.next;
          }
          System.out.println("null");
     }
     private static Node getMid(Node head){
          Node slow=head;
          Node fast=head.next;
          while(fast!=null && fast.next!=null){
               slow=slow.next;
               fast=fast.next;
          }
          return slow; //mid node
     }
     //Merge Sort
     public static Node mergesort(Node head){
          if(head==null||head.next==null){
               return head;
          }
          Node mid=getMid(head);
          //Breaking the list into left & right half
          Node rightHead=mid.next;
          mid.next=null;

          Node left=mergesort(head);
          Node right=mergesort(rightHead);

          return merge(left,right);
     }
     //Merge to sorted half
     public static Node merge(Node head1,Node head2){
          Node mergedLL=new Node(-1);
          Node temp=mergedLL;
          while(head1!=null && head2!=null){
               if(head1.val<=head2.val){
                    temp.next=head1;
                    temp=temp.next;
                    head1=head1.next;
               }
               else{
                    temp.next=head2;
                    temp=temp.next;
                    head2=head2.next;
               }
          }
          while(head1!=null){
               temp.next=head1;
               temp=temp.next;
               head1=head1.next;
          }
          while(head2!=null){
               temp.next=head2;
               temp=temp.next;
               head2=head2.next;
          }
          return mergedLL.next;   //as first node (-1) is an aux.node
     }
     public static void main(String[] args) {
          mergeSort ll=new mergeSort();
          ll.addFirst(1);
          ll.addFirst(2);
          ll.addFirst(3);
          ll.addFirst(4);

          ll.print();
          ll.head=ll.mergesort(ll.head);
          ll.print();
     }
}
