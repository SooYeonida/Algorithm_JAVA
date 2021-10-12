package BOJ;

import java.util.*;

public class 구슬탈출2 {
    static int n;
    static int m;
    static char[][] board;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int answer = 0;
    static boolean[][][][] visit;

    static class Ball {
        int[] red;
        int[] blue;
        int move;

        public Ball() {
            this.move = 0;
        }

        public Ball(Ball now) {
            this.red = now.red.clone();
            this.blue = now.blue.clone();
            this.move = now.move;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        board = new char[n][m];
        Ball b = new Ball();

        for (int i = 0; i < n; i++) {
            String str = in.next();
            for (int j = 0; j < m; j++) {
                board[i][j] = str.charAt(j);
                if (board[i][j] == 'B') {
                    b.blue = new int[]{i, j};
                    board[i][j] = '.';
                } else if (board[i][j] == 'R') {
                    b.red = new int[]{i, j};
                    board[i][j] = '.';
                }
            }
        }

        visit = new boolean[n][m][n][m];
        Queue<Ball> q = new LinkedList<>();
        q.offer(b);
        visit[b.red[0]][b.red[1]][b.blue[0]][b.blue[1]] = true;

        while (!q.isEmpty()) {
            Ball now = q.poll();
            if (board[now.blue[0]][now.blue[1]] == 'O') {
                //파란공이 빠짐
                continue;
            } else if (now.move > 10) {
                //횟수 초과 -1
                continue;
            }

            if (board[now.red[0]][now.red[1]] == 'O') {
                System.out.println(now.move);
                System.exit(0);
            }

            for (int i = 0; i < 4; i++) {
                Ball next = move(i, now); //i : 방향
                if (visit[next.red[0]][next.red[1]][next.blue[0]][next.blue[1]]) {
                    continue;
                }

                visit[next.red[0]][next.red[1]][next.blue[0]][next.blue[1]] = true;
                q.offer(next);

            }
        }
        System.out.println("-1");
    }

    static Ball move(int dir, Ball now) {
        Ball next = new Ball(now);
        int nr = 0, nc = 0, flag = 0;

        if (dir == 0) {
            //상
            if (next.red[0] > next.blue[0]) flag = 0; //파란공 먼저
            else flag = 1; //빨간공 먼저
        } else if (dir == 1) {
            //하
            if (next.red[0] > next.blue[0]) flag = 1;
            else flag = 0;
        } else if (dir == 2) {
            //좌
            if (next.red[1] > next.blue[1]) flag = 0;
            else flag = 1;
        } else {
            //우
            if (next.red[1] > next.blue[1]) flag = 1;
            else flag = 0;
        }

        if (flag == 0) {
            //파란공 먼저 움직이는 경우
            nr = next.blue[0] + dx[dir];
            nc = next.blue[1] + dy[dir];

            while (board[nr][nc] == '.') {
                nr += dx[dir];
                nc += dy[dir];
            }
            if (board[nr][nc] == 'O') {
                next.blue = new int[]{nr, nc};
            } else {//#인 경우
                next.blue = new int[]{nr - dx[dir], nc - dy[dir]};
            }

            nr = next.red[0] + dx[dir];
            nc = next.red[1] + dy[dir];

            while (board[nr][nc] == '.') {
                if (nr == next.blue[0] && nc == next.blue[1]) break;
                nr += dx[dir];
                nc += dy[dir];
            }
            if (board[nr][nc] == 'O') {
                next.red = new int[]{nr, nc};
            } else {
                next.red = new int[]{nr - dx[dir], nc - dy[dir]};
            }
        } else {
            //빨간공 먼저 움직이는 경우
            nr = next.red[0] + dx[dir];
            nc = next.red[1] + dy[dir];

            while (board[nr][nc] == '.') {
                nr += dx[dir];
                nc += dy[dir];
            }
            if (board[nr][nc] == 'O') {
                next.red = new int[]{nr, nc};
            } else {//#인 경우
                next.red = new int[]{nr - dx[dir], nc - dy[dir]};
            }

            nr = next.blue[0] + dx[dir];
            nc = next.blue[1] + dy[dir];
            while (board[nr][nc] == '.') {
                if (nr == next.red[0] && nc == next.red[1]) break;
                nr += dx[dir];
                nc += dy[dir];
            }
            if (board[nr][nc] == 'O') {
                next.blue = new int[]{nr, nc};
            } else {
                next.blue = new int[]{nr - dx[dir], nc - dy[dir]};
            }
        }

        next.move++;
        return next;
    }

}
