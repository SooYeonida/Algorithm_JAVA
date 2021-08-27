package Inflearn;

import java.util.Scanner;

public class 섬나라아일랜드_DFS {
    static int N;
    static int[][] map;
    static int answer = 0; //섬의 개수
    static int[] dx = {-1,-1,0,1,1,1,0,-1};
    static int[] dy = {0,1,1,1,0,-1,-1,-1};
    //문제에서 상하좌우와 대각선이라고 명시

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = in.nextInt();
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1) {
                    answer++;
                    map[i][j] = 0;
                    dfs(i,j);
                }
            }
        }

        System.out.println(answer);
    }

    static void dfs(int x, int y) {
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < N && ny >= 0 && ny < N && map[nx][ny] == 1) {
                map[nx][ny] = 0; //간 곳으로 마크
                dfs(nx,ny);
            }
        }
    }

}

