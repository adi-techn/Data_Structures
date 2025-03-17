public class circularQueue {
     static class MyCircularQueue {
          int[] q;
          int front = 0;
          int rear = -1;
          int size = 0;
          public MyCircularQueue(int k) {
              q=new int[k];
          }
          
          public boolean enQueue(int value) {
              if(size==q.length){
                  return false;
              }
              rear=(rear+1)%q.length;
              q[rear]=value;
              size++;
              return true;
          }
          
          public boolean deQueue() {
              if(size==0){
                  return false;
              }
              front=(front+1)%q.length;
              size--;
              return true;
          }
          
          public int Front() {
              if(size==0){
                  return -1;
              }
              else{
                  return q[front];
              }
          }
          
          public int Rear() {
              if(size==0){
                  return -1;
              }
              else{
                  return q[rear];
              }
          }
          
          public boolean isEmpty() {
              return size==0;
          }
          
          public boolean isFull() {
              return size==q.length;
          }
     }
     public static void main(String[] args) {
          MyCircularQueue q=new MyCircularQueue(5);
          System.out.println(q.isEmpty());
          System.out.println(q.enQueue(10));
          System.out.println(q.enQueue(20));
          System.out.println(q.enQueue(30));
          System.out.println(q.deQueue());
     }
}
