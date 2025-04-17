import java.util.Comparator;
import java.util.PriorityQueue;

public class priorityQueue {
     static class Student implements Comparable<Student>{
          String name;
          int rank;

          public Student(String name,int rank){
               this.rank=rank;
               this.name=name;
          }

          @Override
          public int compareTo(Student s){
               return this.rank-s.rank;
          }
     }
     public static void main(String[] args) {
          PriorityQueue<Student> pq=new PriorityQueue<>(Comparator.reverseOrder());

          pq.add(new Student("A", 20));
          pq.add(new Student("B", 3));
          pq.add(new Student("C", 5));
          pq.add(new Student("D",9));

          while (!pq.isEmpty()) {
               System.out.println(pq.peek().name + "->"+ pq.peek().rank);
               pq.remove();
          }
     }
}
