package BOJ;

import java.util.*;

public class Easy {
        static int n;
        static int[][] board;
        static int answer = 0;

        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            n = in.nextInt();
            board = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    board[i][j] = in.nextInt();
                }
            }

            dfs(0);

            System.out.println(answer);

            in.close();

        }

        static void dfs(int count) {
            if (count == 5) {
                findMax();
                return;
            }


            int[][] copy = new int[n][n];
            for(int i = 0; i < n; i++)
                copy[i] = board[i].clone();
            //이차원배열은 clone으로 깊은 복사 안됨

            for(int dir=0;dir<4;dir++) {
                move(dir);
                dfs(count+1);
                for(int i = 0; i < n; i++)
                    board[i] = copy[i].clone();
            }

        }

        static void move(int dir) {
            if(dir == 0) {
                //상
                for(int i=0;i<n;i++) {
                    int index = 0;
                    int block = 0;
                    for(int j=0;j<n;j++) {
                        if(board[j][i] != 0) {
                            //block : 최근 블록의 수 저장
                            if(block == board[j][i]) {
                                board[index -1][i] = block*2;
                                block = 0;
                                board[j][i] = 0;
                            }
                            else {
                                block = board[j][i];
                                board[j][i] = 0;
                                board[index][i] = block;
                                index++;
                            }
                        }
                    }
                }
            }
            else if(dir == 1) {
                //하
                for(int i=0;i<n;i++) {
                    int index = n-1;
                    int block = 0;
                    for(int j=n-1;j>=0;j--) {
                        if(board[j][i] != 0) {
                            if(block == board[j][i]) {
                                board[index + 1][i] = block*2;
                                block = 0;
                                board[j][i] = 0;
                            }
                            else {
                                block = board[j][i];
                                board[j][i] = 0;
                                board[index][i] = block;
                                index--;
                            }
                        }
                    }
                }
            }
            else if(dir == 2) {
                //좌
                for(int i=0;i<n;i++) {
                    int index = 0;
                    int block = 0;
                    for(int j=0;j<n;j++) {
                        if(board[i][j] != 0) {
                            //block : 최근 블록의 수 저장
                            if(block == board[i][j]) {
                                board[i][index-1] = block*2;
                                block = 0;
                                board[i][j] = 0;
                            }
                            else {
                                block = board[i][j];
                                board[i][j] = 0;
                                board[i][index] = block;
                                index++;
                            }
                        }
                    }
                }
            }
            else {
                //우
                for(int i=0;i<n;i++) {
                    int index = n-1;
                    int block = 0;
                    for(int j=n-1;j>=0;j--) {
                        if(board[i][j] != 0) {
                            if(block == board[i][j]) {
                                board[i][index+1] = block*2;
                                block = 0;
                                board[i][j] = 0;
                            }
                            else {
                                block = board[i][j];
                                board[i][j] = 0;
                                board[i][index] = block;
                                index--;
                            }
                        }
                    }
                }
            }
        }

        static void findMax() {
            for(int i=0;i<n;i++) {
                for(int j=0;j<n;j++) {
                    answer = Math.max(answer,board[i][j]);
                }
            }
        }

}
