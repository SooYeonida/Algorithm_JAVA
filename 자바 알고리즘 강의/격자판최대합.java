package Inflearn;

import java.util.Scanner;

public class 격자판최대합 {
   public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            int[][] array = new int[n][n];
            int answer = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    array[i][j] = in.nextInt();
                }
            }
            
            int total1 = 0;
            int total2 = 0;
            //행, 열
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    total1 += array[i][j];
                    total2 += array[j][i];
                }
                answer = Math.max(answer, total1);
                answer = Math.max(answer,total2);
                total1 = 0;
                total2 = 0;
            }

            //대각선
            for (int i = 0; i < n; i++) {
                total1 += array[i][i];
                total2 += array[i][n-i-1];
            }
            answer = Math.max(answer, total1);
            answer = Math.max(answer,total2);

            System.out.println(answer);
        }
}
