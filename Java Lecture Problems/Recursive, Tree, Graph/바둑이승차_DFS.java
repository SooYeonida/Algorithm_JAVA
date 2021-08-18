package Inflearn;

import java.util.Scanner;

public class 바둑이승차_DFS {
    static int n;
    static int c;
    static int[] weight;
    static int answer = 0;

    public static void main(String args[]) {
        //c이하의 최댓값

        Scanner in = new Scanner(System.in);
        c = in.nextInt(); //트럭 수용 무게
        n = in.nextInt(); //강아지 수

        weight = new int[n];
        for (int i = 0; i < n; i++) {
            weight[i] = in.nextInt();
        }

        dfs(0, 0);
        System.out.println(answer);
    }

    static void dfs(int L, int sum) {
        if(sum>=answer && sum <=c){
            answer = sum;
        }
        if (L == n) {
            return;
        } else {
            dfs(L + 1, sum + weight[L]);
            dfs(L + 1, sum);
        }

    }
}
