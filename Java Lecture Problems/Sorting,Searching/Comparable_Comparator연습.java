package Inflearn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Comparable_Comparator연습 {

//    public static void main(String[] args) {
//        ArrayList<Test> list = new ArrayList<>();
//
//        list.add(new Test(5));
//        list.add(new Test(4));
//        list.add(new Test(2));
//        list.add(new Test(1));
//
//        Comparator<Test> testComparator = new Comparator<Test>() {
//            @Override
//            public int compare(Test o1, Test o2) {
//                return o1.value - o2.value;
//            }
//        };
//
//        Collections.sort(list,testComparator);
//
//        for(Test t : list){
//            System.out.println(t.value);
//        }
//
//    }
//
//    static class Test{
//        public Test(int value) {
//            this.value = value;
//        }
//
//        int value;
//
//    }

    public static void main(String[] args) {
        ArrayList<Test> list = new ArrayList<>();

        list.add(new Test(5));
        list.add(new Test(4));
        list.add(new Test(2));
        list.add(new Test(1));

        Collections.sort(list);

        for(Test t : list){
            System.out.println(t.value);
        }

    }
    static class Test implements Comparable<Test>{
        public Test(int value) {
            this.value = value;
        }

        int value;

        //this.compareTo(o)인것임
        @Override
        public int compareTo(Test o) {
            return this.value-o.value;
        }
    }

}
