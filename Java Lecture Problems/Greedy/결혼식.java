package Inflearn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class 결혼식 {
    public static void main(String[] args) {
        ArrayList<Time> list = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i=0;i<n;i++){
            list.add(new Time(in.nextInt(),'s'));
            list.add(new Time(in.nextInt(),'e'));
        }

        Collections.sort(list, new Comparator<Time>() {
            @Override
            public int compare(Time o1, Time o2) {
                if(o1.time ==o2.time){
                    return o1.status - o2.status;
                }
                return o1.time - o2.time;
            }
        });

//        for(Time t : list){
//            System.out.println(t.time +" "+t.status);
//        }

        int cnt = 0;
        int answer = Integer.MIN_VALUE;
        for(Time t : list) {
            if(t.status=='s'){
                cnt++;
            }
            else if(t.status == 'e'){
                cnt--;
            }
            if(cnt>answer){
                answer = cnt;
            }
        }
        System.out.println(answer);

    }

    static class Time {
        int time;
        char status;
        public Time(int arriveTime, char status){
            this.time = arriveTime;
            this.status = status;
        }
    }
}
