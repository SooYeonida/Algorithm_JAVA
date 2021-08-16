package Inflearn;

import java.util.Scanner;

public class 경로탐색_인접행렬 {
    /*
    방향 그래프가 주어지면 1번 정점에서 N번 정점으로 가는 모든 경로의 가지 수를 출력하는
    프로그램을 작성하세요. 아래 그래프에서 1번 정점에서 5번 정점으로 가는 가지 수는

    1 2 3 4 5
    1 2 3
    1 3 4 2 5
    1 3 4 5
    1 4 2 5
    1 4 5
    총 6가지입니다.

    정점의 수: N
    간선의 수: M
    M줄에 걸쳐 연결정보

    입력 예시:
    5 9
    1 2
    1 3
    1 4
    2 1
    2 3
    2 5
    3 4
    4 2
    4 5

    출력 예시 : 6

     */

    static int n,m,answer = 0;
    static int[][] graph;
    static int[] check;

    //dfs, backtracking
    static void dfs(int v){
        if(v==n) answer++;
        else{
            for(int i=1;i<=n;i++){
                if(graph[v][i]==1 && check[i]==0){
                    check[i] = 1;
                    dfs(i);
                    check[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        graph = new int[n+1][n+1];
        check = new int[n+1];
        for(int i=0;i<m;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            graph[a][b] = 1;
        }
        check[1] = 1;
        dfs(1);
        System.out.println(answer);
    }
}
