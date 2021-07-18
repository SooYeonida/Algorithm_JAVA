package Inflearn;

import java.util.Scanner;

public class 연속부분수열 {
    public static void main(String[] args) {
        //tip:입력받는 수가 십만이 넘는순가 O(n^2)효율갖는 코드는 안되겠다 파악해야함
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        int[] array = new int[n];
        for(int i=0;i<n;i++){
            array[i] = in.nextInt();
        }

        int sum=0, answer=0, begin =0;
        for(int i=0;i<n;i++){
            sum += array[i];
            if(sum == m){
                answer++;
            }
//            else if(sum>m){
//                sum -= array[begin];
//                begin++;
//                if(sum == m){
//                    answer++;
//                }
//            }
            while(sum>=m){
                sum -= array[begin++];
                if(sum == m){
                    answer++;
                }
            }
        }
        //기존 코드의 문제 : sum이 m보다 클 경우 앞쪽부터 빼는 접근은 맞으나
        //내가 짠 코드는 하나빼고 바로 다른 수 하나를 더해서 비교하는 코드여서
        //더 빼야할 필요가 있는 경우를 고려하지 x -> while(sum>=m)으로 해주어야함
        System.out.println(answer);

    }
}
