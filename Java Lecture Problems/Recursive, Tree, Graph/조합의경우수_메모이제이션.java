package Inflearn;

import java.util.Scanner;

public class 조합의경우수_메모이제이션 {

    static int[][] com;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int r = in.nextInt();

        com = new int[n+1][r+1];

        long start = System.currentTimeMillis();

        System.out.println(combi(n,r));

        long end = System.currentTimeMillis();
        System.out.print((end-start)/1000);

    }

    static int combi(int n,int r){
        if(n==r) return 1;
        else if(n-r==1) return n;
        else if(n ==0 || r==0) return 1;
        else{
            int a =0,b=0;
            if(com[n-1][r-1]!=0) {
                a = com[n - 1][r - 1];
            }
            else{
                a = combi(n-1,r-1);
            }
            if(com[n-1][r]!=0) {
                b = com[n - 1][r];
            }
            else{
                b= combi(n-1,r);
            }
            return a+b;
        }
    }
}
