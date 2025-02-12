public class zigZagLL{
     public class Node{
          int data;
          Node next;
  
          public Node(int data){
              this.data=data;
              this.next=null;
          }
     }
     public static Node head;

     public static void zigZag(){
          //Base case
          if(head==null||head.next==null){
               return;
          }
          //Finding mid
          Node slow=head;
          Node fast=head.next;       //For even and odd size of linkedlist
          while(fast!=null && fast.next!=null){
               slow=slow.next;
               fast=fast.next.next;
          }
          Node mid=slow;
          //Reverse right half
          Node prev=null;
          Node curr=mid.next;
          mid.next=null;
          Node next;
          while(curr!=null){
               next=curr.next;
               curr.next=prev;
               prev=curr;
               curr=next;
          }
          //Alternative Merge
          Node LH=head;
          Node RH=prev;
          Node nextL,nextR;
          while(LH!=null && RH!=null){
               //ZIGZAG 
               nextL=LH.next;
               nextR=RH.next;
               LH.next=RH;
               RH.next=nextL;
               //Update
               LH=nextL;
               RH=nextR;
          }
     }
     public void insertionBeginning(int data){
          Node newNode=new Node(data);
          newNode.next=head;
          head=newNode;
     }
     public void printLL() {
          Node temp = head;
          while (temp != null) {
               System.out.print(temp.data + "->");
               temp = temp.next;
          }
          System.out.println("null");
     }
     public static void main(String[] args) {
          zigZagLL ll=new zigZagLL();
          // ll.insertionBeginning(6);
          ll.insertionBeginning(5);
          ll.insertionBeginning(4);
          ll.insertionBeginning(3);
          ll.insertionBeginning(2);
          ll.insertionBeginning(1);

          ll.printLL();
          zigZag();
          ll.printLL();
     }
}
