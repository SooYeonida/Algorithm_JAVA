package Inflearn;

import java.util.Scanner;

public class 동전교환 {
    static int n;
    static int m;
    static int[] coins;
    static int answer = Integer.MAX_VALUE;

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt(); //동전 종류 개수
        coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = in.nextInt();
        }
        m = in.nextInt(); //거슬러줄 금액

        dfs(0,0);
        System.out.println(answer);

    }


    static void dfs(int L,int sum){
        //L: 동전의 개수
        //sum: L개 동전 금액의 총합
        if(L>=answer) return;
        if(sum>m) return; //무한 안돌려면 이게 필요
        if(sum==m){
            answer = Math.min(L,answer);
        }
        else {
            for (int i = n-1; i >= 0; i--) {
                dfs(L + 1, sum + coins[i]);
            }
        }
    }
}
