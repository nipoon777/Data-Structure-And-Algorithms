
import java.util.*;

public class PriorityQueUsage{
    public static class Student implements Comparable <Student>{
        private int rollNo;
        private int marks;
        private int rank;
        
        public Student(int rollNo, int marks, int rank){
            this.rollNo = rollNo;
            this.marks = marks;
            this.rank = rank;
        }
        public String toString(){
            return "Student RollNo =" + rollNo + " Marks = " + marks + " Rank = " + rank;
        }

        public int compareTo(Student o){
            return this.marks - o.marks;
        }
    }
    public static void main(String[] args) {
        
        PriorityQueue < Student > pq = new PriorityQueue<>();

        pq.add( new Student(1, 54, 3));
        pq.add( new Student(2, 75, 2));
        pq.add( new Student(3, 45, 10));
        pq.add( new Student(10, 35, 15));
        pq.add( new Student(17, 15, 25));
        pq.add( new Student(12, 80, 1));

        while( !pq.isEmpty() ){
            System.out.println(pq.remove());
        }
    }
}
