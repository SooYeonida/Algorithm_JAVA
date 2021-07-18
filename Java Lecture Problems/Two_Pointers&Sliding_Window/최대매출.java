package Inflearn;

import java.util.Scanner;

public class 최대매출 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt(); //window 사이즈

        int[] costs = new int[n];
        for(int i=0;i<n;i++){
            costs[i] = in.nextInt();
        }

//        int begin =0, end = begin + k;
//        int max = Integer.MIN_VALUE , total = 0;
//        while(end<n){
//            for(int i = begin;i<end;i++){
//                total += costs[i];
//            }
//            if(max<total) max = total;
//            total = 0;
//            begin++; end++;
//        }
//        시간복잡도 효율이 안좋음.

        int sum=0,answer=0;
        for(int i=0;i<k;i++){
            sum += costs[i];
        } //window사이즈만큼 먼저 더해놓기
        answer = sum;

        for(int i = k;i<n;i++){
            sum += costs[i];
            sum -= costs[i-k];
            answer = Math.max(sum,answer);
        }
        System.out.println(answer);
    }
}
