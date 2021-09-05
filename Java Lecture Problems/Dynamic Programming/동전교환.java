package Inflearn;

import java.util.Arrays;
import java.util.Scanner;

public class 동전교환 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); //동전 종류 개수
        int[] coin = new int[n]; //n개의 동전 종류
        for(int i=0; i<n; i++){
            coin[i]=in.nextInt();
        }
        int m = in.nextInt(); //거슬러줄 금액
        int[] dy = new int[m+1];
        //dy[i] : i 금액을 만드는데 드는 최소 동전 개수
        Arrays.fill(dy,Integer.MAX_VALUE);
        dy[0] = 0;
        for(int i=0;i<n;i++){
            for(int j=coin[i];j<=m;j++){
                dy[j] = Math.min(dy[j],dy[j-coin[i]]+1);
            }
        }

        System.out.println(dy[m]);

    }
}
