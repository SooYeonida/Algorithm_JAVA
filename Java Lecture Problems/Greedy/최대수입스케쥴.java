package Inflearn;

import java.util.*;

public class 최대수입스케쥴 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        ArrayList<Semina> list = new ArrayList<>();
        for(int i =0; i<n;i++){
            list.add(new Semina(in.nextInt(),in.nextInt()));
        }

        Comparator<Semina> comparator = new Comparator<Semina>() {
            @Override
            public int compare(Semina o1, Semina o2) {
                return o2.day - o1.day;
            }
        };
        Collections.sort(list,comparator);

        int max_pay = 0;
        int max_day = list.get(0).day;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

        int j=0;
        for(int i=max_day ;i>=1;i--){
            for(;j<n;j++){
                if(list.get(j).day<i) break;
                priorityQueue.offer(list.get(j).pay);
            }
            if(!priorityQueue.isEmpty()) {
                int tmp = priorityQueue.poll();
                max_pay+=tmp;
                System.out.println(tmp);
            }
        }

        System.out.println(max_pay);
    }

    static class Semina{
        int pay;
        int day;
        public Semina(int pay,int day){
            this.pay = pay;
            this.day = day;
        }
    }
}
