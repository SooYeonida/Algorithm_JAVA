package Inflearn;

import java.util.*;
public class 미로탐색_DFS {
    final static int N = 7;
    static int answer = 0;//도착지까지 갈 수 있는 방법의 수
    static int[][] board = new int[N+1][N+1];
    static int[] dir_x = {-1,0,1,0};
    static int[] dir_y = {0,1,0,-1}; //6시 -> 3시 -> 12시 ->9시 방향

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        for(int i=1;i<N+1;i++){
            for(int j=1;j<N+1;j++){
                board[i][j] = in.nextInt();
            }
        }

        board[1][1] = 1;
        dfs(1,1);

        System.out.println(answer);
    }

    static void dfs(int row,int col){
        if(row==N && col ==N){
            answer++;
            return;
        }
        else{
            //방향보면서 뻗어나가야함
            for(int i=0;i<4;i++){
                int nx = row+dir_x[i];
                int ny = col+dir_y[i];
                if(nx>=1 && nx<=7 && ny>=1 && ny<=7 && board[nx][ny]==0){
                    //경계선 내부에 있고 갈수 있는 지점인지
                    board[nx][ny] = 1;
                    dfs(nx,ny);
                    board[nx][ny] = 0;
                }
            }

        }
    }

}
