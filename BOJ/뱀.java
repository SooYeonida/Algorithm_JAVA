package BOJ;
import java.util.*;

public class 뱀 {
        static int n;
        static int[][] board;
        // 상하좌우 1 2 3 4
        static int snake_dir = 4; // 기본 방향 오른쪽
        static int[][] check; // 뱀이 있는 위치 체크
        static Deque<Point> moveQueue = new LinkedList<>();

        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            n = in.nextInt(); // 보드 크기
            board = new int[n][n];
            int k = in.nextInt(); // 사과 개수
            for (int i = 0; i < k; i++) {
                int row = in.nextInt()-1;
                int col = in.nextInt()-1;
                board[row][col] = -1; // 사과 표시
            }

            int l = in.nextInt(); // 뱀의 방향정보 개수
            Queue<Move> q = new LinkedList<>();
            for (int i = 0; i < l; i++) {
                int t = in.nextInt();
                char dir = in.next().charAt(0);
                q.add(new Move(t, dir));
            }

            // 시뮬레이션 시작
            check = new int[n][n];
            check[0][0] = 1;
            moveQueue.add(new Point(0, 0));
            int answer = 0; // 게임 시간

            while (true) {
                // 방향으로 한칸 이동
                answer++;
                boolean result = move();
                if (!result)
                    break;

                if (!q.isEmpty()) {
                    if (answer == q.peek().t) {
                        // 방향변경
                        changeDirection(q.poll().dir);
                    }
                }
            }

            System.out.println(answer);
        }

        static boolean move() { // 한칸 이동
            Point head = moveQueue.peekFirst();
            Point tail = moveQueue.peekLast();

            if (snake_dir == 1) {
                // 상
                if (head.row - 1 >= 0 && head.row - 1 < n && head.col >= 0 && head.col < n
                        && check[head.row - 1][head.col] != 1) {
                    if (board[head.row - 1][head.col] == -1) {
                        // 사과
                        check[head.row - 1][head.col] = 1;
                        board[head.row - 1][head.col] = 0;
                        moveQueue.addFirst(new Point(head.row - 1, head.col));
                    } else {
                        // 사과 x
                        check[head.row - 1][head.col] = 1;
                        moveQueue.addFirst(new Point(head.row - 1, head.col));
                        moveQueue.pollLast();
                        check[tail.row][tail.col] = 0;
                    }


                } else
                    return false;

            } else if (snake_dir == 2) {
                // 하
                if (head.row + 1 >= 0 && head.row + 1 < n && head.col >= 0 && head.col < n
                        && check[head.row + 1][head.col] != 1) {
                    if (board[head.row + 1][head.col] == -1) {
                        // 사과
                        check[head.row + 1][head.col] = 1;
                        board[head.row + 1][head.col] = 0;
                        moveQueue.addFirst(new Point(head.row + 1, head.col));
                    } else {
                        // 사과 x
                        check[head.row + 1][head.col] = 1;
                        moveQueue.addFirst(new Point(head.row + 1, head.col));
                        moveQueue.pollLast();
                        check[tail.row][tail.col] = 0;
                    }

                } else
                    return false;
            } else if (snake_dir == 3) {
                // 좌
                if (head.row >= 0 && head.row < n && head.col - 1 >= 0 && head.col - 1 < n
                        && check[head.row][head.col - 1] != 1) {
                    if (board[head.row][head.col - 1] == -1) {
                        // 사과
                        check[head.row][head.col - 1] = 1;
                        board[head.row][head.col - 1] = 0;
                        moveQueue.addFirst(new Point(head.row, head.col - 1));
                    } else {
                        // 사과 x
                        check[head.row][head.col - 1] = 1;
                        moveQueue.addFirst(new Point(head.row, head.col - 1));
                        moveQueue.pollLast();
                        check[tail.row][tail.col] = 0;
                    }

                } else
                    return false;
            } else {
                // 우
                if (head.row >= 0 && head.row < n && head.col + 1 >= 0 && head.col + 1 < n
                        && check[head.row][head.col + 1] != 1) {
                    if (board[head.row][head.col + 1] == -1) {
                        // 사과
                        check[head.row][head.col + 1] = 1;
                        board[head.row][head.col + 1] = 0;
                        moveQueue.addFirst(new Point(head.row, head.col + 1));
                    } else {
                        // 사과 x
                        check[head.row][head.col + 1] = 1;
                        moveQueue.addFirst(new Point(head.row, head.col + 1));
                        moveQueue.pollLast();
                        check[tail.row][tail.col] = 0;
                    }

                } else
                    return false;
            }
            return true;
        }

        static void changeDirection(char dir) { // 방향 변경
            if (dir == 'L') {
                if (snake_dir == 1) {
                    snake_dir = 3;
                } else if (snake_dir == 2) {
                    snake_dir = 4;// 4
                } else if (snake_dir == 3) {
                    snake_dir = 2;
                } else {
                    snake_dir = 1;
                }
            } else {
                if (snake_dir == 1) {
                    snake_dir = 4;
                } else if (snake_dir == 2) {
                    snake_dir = 3;
                } else if (snake_dir == 3) {
                    snake_dir = 1;
                } else {
                    snake_dir = 2;
                }
            }
        }

        static class Point {
            int row;
            int col;

            public Point(int row, int col) {
                this.row = row;
                this.col = col;
            }
        }

        static class Move {
            int t;
            char dir;

            public Move(int t, char dir) {
                this.t = t;
                this.dir = dir;
            }
        }
}
