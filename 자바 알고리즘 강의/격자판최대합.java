package Inflearn;

import java.util.Scanner;

public class 격자판최대합 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] array = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = in.nextInt();
            }
        }

        int max = -1;
        int total = 0;
        //행
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                total += array[i][j];
            }
            max = Math.max(max, total);
            total = 0;
        }
        //열
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                total += array[j][i];
            }
            max = Math.max(max, total);
            total = 0;
        }
        //대각선
        for (int i = 0; i < n; i++) {
            total += array[i][i];
        }
        max = Math.max(max, total);

        System.out.println(max);
    }
}
