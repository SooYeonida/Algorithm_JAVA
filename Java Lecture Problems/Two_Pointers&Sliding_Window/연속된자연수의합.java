package Inflearn;

import java.util.Scanner;

public class 연속된자연수의합 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int[] array = new int[n];
        for(int i=0;i<n;i++){
            array[i] = i+1;
        }

        int sum=0, answer=0, begin =0;
        for(int i=0;i<n;i++){
            sum += array[i];
            if(sum == n){
                answer++;
            }
            while(sum>=n){
                sum -= array[begin++];
                if(sum == n && begin!=n-1){
                    answer++;
                }
                //입력이 15일 경우 15/2 = 7+1 이상의 값이 연속될수 x 8+9만해도 16이니까
                //begin조건 걸어줄 필요없이 애초에 입력을 n/2+1까지만 해주면 됨.
            }
        }
        System.out.println(answer);

    }
}
