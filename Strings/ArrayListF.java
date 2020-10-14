package Strings;
import java.util.*;


public class ArrayListF {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(100);
        list.add(200);
        list.add(300);

        System.out.println(list + " -> " + list.size());

        list.get(1);
        System.out.println(list.get(1));
        list.add(1,500);
        System.out.println(list);
        list.set(1, 5225);
        System.out.println(list);

        list.remove(2);
        System.out.println(list);

        for(int val : list){
            System.out.println(val);
        }
    }
    
}
