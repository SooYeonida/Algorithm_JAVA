package Inflearn;

import java.util.Scanner;

public class 최대점수구하기 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt(); //문제의 개수
        int m = in.nextInt(); //제한 시간
        int[] dy = new int[m+1];
        
        for(int i=0;i<n;i++){
            int s = in.nextInt();
            int t = in.nextInt();

            for(int j=m;j>=t;j--){
                dy[j] = Math.max(dy[j],dy[j-t]+s);
            }
        }

        System.out.println(dy[m]);
    }
}
