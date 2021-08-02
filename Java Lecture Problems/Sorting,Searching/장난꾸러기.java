package Inflearn;

import java.util.Arrays;
import java.util.Scanner;

public class 장난꾸러기 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] students = new int[n];
        for (int i = 0; i < n; i++) {
            students[i] = in.nextInt();
        }

        int[] tmp = students.clone();
        Arrays.sort(tmp);

        for (int i = 0; i < students.length; i++) {
            if (tmp[i] != students[i]) {
                System.out.print((i + 1) + " ");
            }
        }

    }
}
