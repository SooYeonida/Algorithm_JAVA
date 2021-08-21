package Inflearn;

import java.util.Arrays;
import java.util.Scanner;

public class 회의실배정 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Conference[] list = new Conference[n];
        for(int i=0;i<n;i++){
            list[i] = new Conference(in.nextInt(),in.nextInt());
        }

        Arrays.sort(list);

        int et = 0,count =0;
        for(Conference c : list){
            if(c.start>=et){
                count++;
                et = c.end;
            }
        }

        System.out.println(count);

    }

    static class Conference implements Comparable<Conference>{
        int start;
        int end;

        public Conference(int start,int end){
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Conference o) {
            if(this.end == o.end) return this.start-o.start;
            return this.end-o.end;
        }
    }

}
