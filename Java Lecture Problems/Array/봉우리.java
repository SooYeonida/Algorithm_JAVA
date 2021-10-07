package Inflearn;

import java.util.Scanner;

public class 봉우리 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] board = new int[n+2][n+2];

        //상하좌우
        int[] dx = {0,0,-1,1};
        int[] dy = {1,-1,0,0};

        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                board[i][j] = in.nextInt();
            }
        }

        int count = 0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                //상하좌우 검사
                boolean check = true;
                for(int k=0;k<4;k++) {
                    if(board[i+dx[k]][j+dy[k]]>=board[i][j]){
                        check = false;
                        break;
                    }
                }
                if(check) count++;

            }
        }

        System.out.println(count);
    }
}
