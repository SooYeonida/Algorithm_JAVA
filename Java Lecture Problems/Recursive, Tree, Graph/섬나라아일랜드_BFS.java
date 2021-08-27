package Inflearn;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 섬나라아일랜드_BFS {
    static int N;
    static int[][] map;
    static int answer = 0; //섬의 개수
    static int[] dx = {-1,-1,0,1,1,1,0,-1};
    static int[] dy = {0,1,1,1,0,-1,-1,-1};
    //문제에서 상하좌우와 대각선이라고 명시
    static Queue<Point> queue = new LinkedList<>();

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
                    queue.add(new Point(i,j));
                    map[i][j] = 0;
                    bfs();
                }
            }
        }

        System.out.println(answer);
    }

    static void bfs() {
        while(!queue.isEmpty()){
            Point cp = queue.poll();
            for (int i = 0; i < 8; i++) {
                int nx = cp.x + dx[i];
                int ny = cp.y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < N && map[nx][ny] == 1) {
                    map[nx][ny] = 0; //간 곳으로 마크
                    queue.add(new Point(nx,ny));
                }
            }
        }
    }

    static class Point{
        int x;
        int y;
        public Point(int x,int y){
            this.x = x;
            this.y = y;
        }
    }

}
