package Inflearn;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 미로의최단거리통로_BFS {

    final static int N = 7;
    static int answer = -1;
    static int[][] board = new int[N+1][N+1];
    static int[] dir_x = {-1,0,1,0};
    static int[] dir_y = {0,1,0,-1}; //6시 -> 3시 -> 12시 ->9시 방향
    static Queue<Point> queue = new LinkedList<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        for(int i=1;i<N+1;i++){
            for(int j=1;j<N+1;j++){
                board[i][j] = in.nextInt();
            }
        }

        queue.offer(new Point(1,1));
        bfs();

        System.out.println(answer);
    }

    static void bfs(){
        while(!queue.isEmpty()){
            Point p = queue.poll();

            for(int i=0;i<4;i++){
                int nx = p.x +dir_x[i];
                int ny = p.y +dir_y[i];
                if(nx>=1 && nx<=7 && ny>=1 && ny<=7 && board[nx][ny]==0){
                    //경계선 내부에 있고 갈수 있는 지점인지
                    board[nx][ny] = board[p.x][p.y]+1;
                    queue.offer(new Point(nx,ny));
                }
            }
        }

        if(board[N][N] ==0) answer = -1;
        else answer = board[N][N];
    }

    static class Point {
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

}
