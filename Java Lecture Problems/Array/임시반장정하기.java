package Inflearn;

import java.util.Scanner;

public class 임시반장정하기 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); //학생수
        int[][] student = new int[n][5];
        for(int i=0;i<n;i++){
            for(int j=0;j<5;j++){
                student[i][j] = in.nextInt();
            }
        }

        ArrayList<Student> list = new ArrayList<>();
        for(int k=0;k<n;k++) {
            int count = 0; //같은 반이었던 학생 수
            ArrayList<Integer> check = new ArrayList<>();
            //학생별
            for (int i = 0; i < 5; i++) {
                //학년
                int classNum = student[k][i];
                for (int j = 0; j < n; j++) {
                    if (j != k) {
                        if(student[j][i] == classNum & !check.contains(j)) {
                            check.add(j);
                            count++;
                        }
                    }
                }
            }
            list.add(new Student(k+1,count));
        }

        Collections.sort(list);
        System.out.println(list.get(0).index);
    }

    static class Student implements Comparable<Student>{
        @Override
        public int compareTo(Student o){
            if(o.count==this.count){
                return this.index-o.index;
            }
            return o.count - this.count;
        }

        int index;
        int count;

        public Student(int index, int count) {
            this.index = index;
            this.count = count;
        }
    }
}

