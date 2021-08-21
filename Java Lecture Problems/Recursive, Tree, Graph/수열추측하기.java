package Inflearn;

import java.util.Scanner;

public class 수열추측하기 {
    static int n;
    static int f;
    static int[] b; //combination값 저장하는 배열 예를들어 3c0 3c1 3c2 3c3 값 담는 배열
    static int[] p; //순열 값 예를들어 1 2 3 4
    static int[] check;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        f = in.nextInt();
        b = new int[n];
        p = new int[n];
        check = new int[n+1];

        for(int i=0;i<n;i++){
            b[i] = combi(n-1,i);
        }

        dfs(0,0);
    }

    //순열 구하기
    static boolean flag = false;
    static void dfs(int L,int sum){
        if(flag==true) return;
        if(L == n){
            if(sum==f){
                for(int a: p)
                System.out.print(a+" ");
                flag = true;
            }
        }
        else{
            for(int i=1;i<=n;i++){
                if(check[i]==0){
                    check[i] = 1;
                    p[L] = i;
                    dfs(L+1,sum+(p[L]*b[L]));
                    check[i] = 0;
                }
            }
        }
    }

    //조합 경우의 수
    static int[][] com = new int[35][35];
    static int combi(int n,int r){
        if(com[n][r]>0) return com[n][r];
        if(n==r || r==0) return 1;
        if(n-r==1) return n;
        else return com[n][r] = combi(n-1,r-1) + combi(n-1,r);
    }

}
