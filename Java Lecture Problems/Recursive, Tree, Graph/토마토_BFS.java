package Inflearn;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 토마토_BFS {
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int[][] box;
    static int[][] dis;
    static Queue<Point> queue = new LinkedList<>();
    static int m;
    static int n;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        m = in.nextInt();
        n = in.nextInt();

        box = new int[n][m];
        dis = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                box[i][j] = in.nextInt();
                if(box[i][j]==1) queue.offer(new Point(i,j));
            }
        }

        bfs();

        boolean flag = true;
        int answer = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(box[i][j]==0) flag = false;
            }
        }

        if(flag){
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    answer = Math.max(answer,dis[i][j]);
                }
            }
        }
        else{
            answer = -1;
        }

        System.out.println(answer);
    }

    static void bfs(){
        while (!queue.isEmpty()){
            Point p = queue.poll();
                for(int i=0;i<4;i++) {
                    int nx = p.x + dx[i];
                    int ny = p.y + dy[i];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < m && box[nx][ny] == 0) {
                        box[nx][ny] = 1;
                        queue.offer(new Point(nx, ny));
                        dis[nx][ny] = dis[p.x][p.y] + 1;
                    }
                }
            }
        }

    static class Point{
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
