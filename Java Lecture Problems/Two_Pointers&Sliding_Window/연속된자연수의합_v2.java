package Inflearn;

import java.util.Scanner;

public class 연속된자연수의합_v2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int answer=0,cnt=1;
        n--;
        while(n>0){
            cnt++;
            n=n-cnt;
            if(n%cnt==0){
                //연속된 자연수가 가능함
                answer++;
            }
        }

        System.out.println(answer);
    }
}
