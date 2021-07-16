package Inflearn;

import java.util.Scanner;

public class 봉우리 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] array = new int[n + 2][n + 2];

        for (int i = 0; i < n + 2; i++) {
            for (int j = 0; j < n + 2; j++) {
                if (i != 0 && j != 0 && i != n+1 && j != n+1) {
                    array[i][j] = in.nextInt();
                } else {
                    array[i][j] = 0;
                }
            }
        }

        int total = 0;
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < n+1; j++) {
                int center = array[i][j];
                int up = array[i - 1][j];
                int down = array[i + 1][j];
                int left = array[i][j - 1];
                int right = array[i][j + 1];
                if (center > up && center > down && center > left && center > right) {
                    total++;
                }
            }
        }

        System.out.println(total);
    }
}
