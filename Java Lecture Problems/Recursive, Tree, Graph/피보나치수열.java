package Inflearn;

import java.util.Scanner;

public class 피보나치수열 {
    /*
    1. 시간 엄청 오래걸리는 경우
    for돌면서 fibo(n) 출력 하는 경우

    2. 8초 정도 걸리는 경우
    fibo(n)한번 호출하고 값들을 fibo[]에 저장.
    for문 돌면서 배열 값만 출력

    3. 1초로 단축되는 경우 -> 메모이제이션 활용
    메모이제이션: 함수의 호출 결과를 캐싱하여 함수가 재호출 될 때 저장해두었던 값을 리턴하는 방식
    fibo(n)호출 시 안에서 fibo[]값 확인하면서 기존에 있는 값은 새로 재귀 호출 안하게끔 확인.
     */

    static int[] fibo;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        fibo = new int[n+1];
        fibonacci(n);
        //저장해놓고 for문 돌리는게 시간단축
        for(int i=1;i<=n;i++) System.out.print(fibo[i]+" ");
    }

    static int fibonacci(int n){
        if(fibo[n]>0) return fibo[n];

        if(n==1 || n==2){
            return fibo[n] = 1;
        }
        else{
          return fibo[n] = fibonacci(n-1) + fibonacci(n-2);
        }
    }
}
