package BOJ;

import java.util.*;

public class 핀볼게임 {
    static int answer;
    static int[][] board;
    static int[][][] worm;
    static int n;
    // 동서남북
    static int[] dir_x = {0, 0, 1, -1};
    static int[] dir_y = {1, -1, 0, 0};

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();

        for (int t = 0; t < T; t++) {
            n = in.nextInt();
            board = new int[n + 2][n + 2];
            // 웜홀
            worm = new int[5][2][2];
            boolean isExistHole[] = new boolean[5];
            answer = 0;

            for (int i = 0; i < n + 2; i++) {
                board[i][0] = board[i][n + 1] = board[0][i] = board[n + 1][i] = 5;
            }

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    board[i][j] = in.nextInt();

                    if (board[i][j] >= 6 && board[i][j] <= 10) {
                        // 웜홀
                        int hole = board[i][j] - 6;
                        if (!isExistHole[hole]) {
                            isExistHole[hole] = true;
                            worm[hole][0][0] = i;
                            worm[hole][0][1] = j;
                        } else {
                            worm[hole][1][0] = i;
                            worm[hole][1][1] = j;
                        }
                    }
                }
            }

            // 수행
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (board[i][j] == 0) {
                        // 빈공간에 대해서 시작위치로 잡고 수행
                        for (int dir = 0; dir < 4; dir++) {
                            bfs(i, j, dir);
                        }
                    }
                }
            }
            System.out.println("#" + t + " " + answer);
        }

    }

    static void bfs(int startRow, int startCol, int startDir) {

        int score = 0;
        int row = startRow;
        int col = startCol;
        int dir = startDir;

        while (true) {
            row += dir_x[dir];
            col += dir_y[dir];

            // 시작위치로 돌아왔거나 블랙홀이면 종료.
            if ((row == startRow && col == startCol) || board[row][col] == -1) {
                answer = Math.max(answer, score);
                break;
            }

            // 벽에 부딪힌 경우 -> 방향 바꿈
            if (board[row][col] >= 1 && board[row][col] <= 5) {
                dir = changeDirection(dir, board[row][col]);
                score++;
            }
            // 웜홀에 빠진 경우 -> 다른 웜홀로 위치 이동
            else if (board[row][col] >= 6 && board[row][col] <= 10) {
                int hole = board[row][col] - 6;
                if (worm[hole][0][0] == row && worm[hole][0][1] == col) {
                    row = worm[hole][1][0];
                    col = worm[hole][1][1];
                } else {
                    row = worm[hole][0][0];
                    col = worm[hole][0][1];
                }
            }
        }
    }

    static int changeDirection(int dir, int wall) {
        if (dir == 0) {
            // 상
            if (wall == 1 || wall == 2 || wall == 5) {
                return 1;
            } else if (wall == 3) {
                return 2;
            } else {
                return 3;
            }
        } else if (dir == 1) {
            // 하
            if (wall == 3 || wall == 4 || wall == 5) {
                return 0;
            } else if (wall == 1) {
                return 3;
            } else {
                return 2;
            }

        } else if (dir == 2) {
            // 좌
            if (wall == 2 || wall == 3 || wall == 5) {
                return 3;
            } else if (wall == 1) {
                return 0;
            } else {
                return 1;
            }
        } else {
            // 우
            if (wall == 1 || wall == 4 || wall == 5) {
                return 2;
            } else if (wall == 2) {
                return 0;
            } else {
                return 1;
            }

        }
    }

}
