package Inflearn;

import java.util.Scanner;

public class 계단오르기 {
    /*
    dp bottom-up방법
    복잡한 문제를 직관적으로 알 수 있는 작은 단위의 문제로 축소해서 확장시켜나가는 방법

    <dp아이디어>
    dy배열 선언
    dy = new int[n+1];
    dy[1] = 1;
    dy[2] = 2;
    for(int i=3;i<=n;i++){
        dy[i] = dy[i-2] + dy[i-1];
    }
    return dy[n];
    */

    static int n;
    static int answer=0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();

        dfs(0);
        System.out.println(answer);
    }

    static void dfs(int sum){
        if(sum>n) return;
        if(sum==n){
            answer++;
        }
        else{
            dfs(sum+1);
            dfs(sum+2);
        }
    }
}
