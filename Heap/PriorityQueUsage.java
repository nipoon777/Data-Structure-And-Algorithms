
import java.util.*;

public class PriorityQueUsage{
    public static class PriorityQueue < T >{
        ArrayList < T > data;
        Comparator< T > comp;
        PriorityQueue(){
            data = new ArrayList<>();
            comp = null;
        }
        PriorityQueue(Comparator <T> comp){
            data = new ArrayList<>();
            this.comp = comp;
        }

        public void add(T val){
            data.add(val);
            upheapify(data.size() - 1);
        }

        public void upheapify(int cidx){
            if( cidx == 0){
                return;
            }
            int pidx = (cidx - 1) / 2;

            if( isSmaller(pidx, cidx)){
                swap(pidx, cidx);
                upheapify(pidx);
            }
        }
        public void swap(int pidx, int cidx){
            T pVal = data.get(pidx);
            T cVal = data.get(cidx);

            data.set(pidx, cVal);
            data.set(cidx, pVal);
        }

        public boolean isSmaller(int pidx, int cidx){
            if(comp == null){
                Comparable pVal = (Comparable) data.get(pidx);
                Comparable cVal = (Comparable) data.get(cidx);

                if(cVal.compareTo(pVal) < 0){
                    return true;
                }else{
                    return false;
                }
            }else{
                T pVal =  data.get(pidx);
                T cVal =  data.get(cidx);

                if( comp.compare(cVal, pVal) < 0){
                    return true;
                }else{
                    return false;
                }

            }
        }
        public T remove(){
            if(data.size() == 0){
                return null;
            }
            T val = data.get(0);
            data.set(0, data.get(data.size() - 1));
            data.remove(data.size() - 1);

            downheapify(0);
            return val;
        }

        public void downheapify(int pidx){
            int minIdx = pidx;

            int leftIdx = 2 * pidx + 1;
            int rightIdx = 2 * pidx + 2;

            if(leftIdx < data.size() && isSmaller(minIdx,leftIdx)){
                minIdx = leftIdx;
            }
            if(rightIdx < data.size() && isSmaller(minIdx,rightIdx)){
                minIdx = rightIdx;
            }

            if( minIdx != pidx ){
                swap(pidx, minIdx);
                downheapify(minIdx);
            }
        }

        public int size(){
            return data.size();
        }
    }
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
    public static class StudentRankComp implements Comparator <Student> {

        public int compare(Student s1, Student s2){
            return s1.rank - s2.rank;
        }
    }
    public static class StudentRollNoComp implements Comparator <Student> {

        public int compare(Student s1, Student s2){
            return s1.rollNo - s2.rollNo;
        }
    }

    

    public static void main(String[] args) {
        
        PriorityQueue < Student > pq = new PriorityQueue<>(new StudentRankComp());

        pq.add( new Student(1, 54, 3));
        pq.add( new Student(2, 75, 2));
        pq.add( new Student(3, 45, 10));
        pq.add( new Student(10, 35, 15));
        pq.add( new Student(17, 15, 25));
        pq.add( new Student(12, 80, 1));

        while( pq.size() > 0 ){
            System.out.println(pq.remove());
        }
    }
}
