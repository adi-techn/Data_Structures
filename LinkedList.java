public class LinkedList{
    public class Node{
        int data;
        Node next;

        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;

    public void insertionBeginning(int data){
        Node newNode=new Node(data); size++;
        if(head==null){
            head=tail=newNode;
        }
        newNode.next=head;
        head=newNode;
    }
    public void insertionEnd(int data){
        Node newNode=new Node(data); size++;
        if(head==null){
            head=tail=newNode;
        }
        tail.next=newNode;
        tail=newNode;
    }
    public void insertionMid(int idx,int data){
        if(idx==0){
            insertionBeginning(data);
            return;
        }
        Node newNode=new Node(data); size++;
        Node temp=head;
        int i=0;
        while(i<idx-1){
            temp=temp.next;
            i++;
        }
        newNode.next=temp.next;
        temp.next=newNode;
    }
    public void deletionBeginning(){
        if(head==null){
            return;
        }
        head=head.next;
    }
    public void deletionEnd(){
        if(head==null){
            System.out.println("List is empty");
        }
        Node prev=head;
        for(int i=0;i<size-2;i++){
            prev=prev.next;
        }
        prev.next=null;
        tail=prev;
        size--;
    }
    public void deleteNthfromEnd(int n){       //L.C. 19
        int sz=0;
        Node temp=head;
        while(temp!=null){
            sz++;
            temp=temp.next;
        }
        
        if(n==sz){
            head=head.next;
            return;
        }

        int i=1;
        int iToFind=sz-n;
        Node prev=head;
        while(i<iToFind) {
            prev=prev.next;
            i++;
        }
        prev.next=prev.next.next;
        return;
    }
    public void reverse(){                     //L.C. 212
        Node prev=null;
        Node curr=head;
        Node next;

        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        head=prev;
    }
    public int search(int val){
        Node temp=head;
        for(int i=0;i<size;i++){
            if(temp.data==val){
                return i;
            }
            temp=temp.next;
        }
        return -1;
    }

    //Slow-Fast Approach
    public static Node findMid(Node head){          //L.C. 876
        Node slow=head,fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;         //Slow +1 steps
            fast=fast.next.next;    //Fast +2 steps
        }
        return slow;
    }

    public static boolean isPalin(){             //L.C. 234
        if(head==null || head.next==null){
            return true;
        }
        //Find the mid node
        Node midNode=findMid(head); 

        //Reverse right half 
        Node prev=null;
        Node curr=midNode;
        while(curr!=null){
            Node next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }

        Node right=prev;    //Head of right half
        Node left=head;     //Head of left half

        //Check left and right half
        while(right!=null){
            if(left.data!=right.data){
                return false;
            }
            left=left.next;
            right=right.next;
        }
        return true;
    }
    public void printLL(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.print("null");
        System.out.println();
    }
    public static void main(String[] args) {
        LinkedList ll=new LinkedList();

        ll.insertionBeginning(3);
        ll.insertionBeginning(2);
        ll.insertionBeginning(1);

        ll.insertionEnd(5);
        ll.insertionEnd(6);

        ll.insertionMid(2, 4);
        ll.printLL();

        System.out.println("Index position::"+ll.search(4));
        // System.out.println(size);

        ll.deletionEnd();
        ll.printLL();

        ll.deleteNthfromEnd(2);
        ll.printLL();

        System.out.println(isPalin());
    }
}
