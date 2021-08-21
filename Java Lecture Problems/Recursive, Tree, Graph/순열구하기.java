package Inflearn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class 순열구하기 {
    //경로탐색 인접행렬, 인접리스트 문제와 알고리즘 동일

    /*
    10이하 N개 자연수가 주어지면 이 중 M개를 뽑아 일렬로 나열하는 방법을 모두 출력합니다.

    입력설명:
    첫번째줄에 자연수 N과 M이 주어집니다.
    두번째줄에 N개의 자연수가 오름차순으로 주어집니다.

    출력설명:
    첫번째줄에 결과를 출력합니다.
    출력순서는 사진순으로 오름차순으로 출력합니다.

    입력예제:
    3 2
    3 6 9

    출력예제
    3 6
    3 9
    6 3
    6 9
    9 3
    9 6
     */

    static int n;
    static int m;
    static int[] pm;
    static int[] num;
    static int[] check;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();

        pm = new int[m];
        check = new int[n];

        num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = in.nextInt();
        }

        dfs(0);

    }

    static void dfs(int L) {
        if (L == m) {
            for (int a : pm) {
                System.out.print(a + " ");
            }
            System.out.println();
        } else {
            for (int i = 0; i < n; i++) {
                if (check[i] == 0) {
                    pm[L] = num[i];
                    check[i] = 1;
                    dfs(L+1);
                    check[i] = 0;
                }
            }
        }
    }
}
