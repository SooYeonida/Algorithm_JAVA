package Inflearn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 그래프최단거리 {
    /*
    다음 그래프에서 1번 정점에서 각 정점으로 가는 최소 이동 간선수를 출력하세요.

    정점의 수 n
    간선의 수 m

    입력예시:
    6 9
    1 3
    1 4
    2 1
    2 5
    3 4
    4 5
    4 6
    6 2
    6 5

    출력예시:
    2 : 3
    3 : 1
    4 : 1
    5 : 2
    6 : 2
     */

    static int n, m = 0;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] check;
    static int[] answer;

    static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);
        check[v] = 1;
        int L = 1;

        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                int r = queue.poll();
                for(int nv : graph.get(r)) {
                    if (check[nv] == 0) {
                        queue.offer(nv);
                        check[nv] = 1;
                        answer[nv] = L;
                    }
                }
            }
            L++;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();

        graph = new ArrayList<ArrayList<Integer>>();
        check = new int[n + 1];
        answer = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            graph.get(a).add(b);
        }

        check[1] = 1;
        bfs(1);

        for (int i = 2; i < answer.length; i++) {
            System.out.println(i + " : " + answer[i]);
        }
    }
}
