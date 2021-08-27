package Inflearn;

import java.util.ArrayList;
import java.util.Scanner;

public class 피자배달거리_DFS_삼성SW역량평가 {
    static int n;
    static int m;
    static int[][] board;
    static ArrayList<Point> house;
    static ArrayList<Point> pizza;

    //조합
    static int[] combi;
    static int minPizzaDistanceSum = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();//도시 지도 크기
        m = in.nextInt();//살리고자 하는 피자집 개수
        board = new int[n + 1][n + 1];//1-n까지

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                board[i][j] = in.nextInt();
            }
        }

        house = new ArrayList<>();
        pizza = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (board[i][j] == 2)
                    pizza.add(new Point(i, j));
                if (board[i][j] == 1)
                    house.add(new Point(i, j));
            }
        }

        combi = new int[m];

        dfs(0, 0);
        //피자집 개수 중에 m개 뽑는 조합 구하기
        System.out.println(minPizzaDistanceSum);
    }

    static void dfs(int L, int start) {
        if (L == m) {
            //조합 완성 combi
            int sum = calDeliveryDistance(combi);
            if (minPizzaDistanceSum >= sum) {
                minPizzaDistanceSum = sum;
            }
        } else {
            for (int i = start; i < pizza.size(); i++) {
                combi[L] = i;
                dfs(L + 1, i + 1);
            }
        }
    }

    static int calDeliveryDistance(int[] combi) {
        //combi를 써야함
        int minDistance = Integer.MAX_VALUE;
        int sum = 0;
        for (Point h : house) {
            //각 피자집들에 대해서 배달거리 구하고 최솟값 찾기
            for (int index : combi) {
                Point p = pizza.get(index);
                int dis = Math.abs(p.x - h.x) + Math.abs(p.y - h.y);
                if (minDistance >= dis) {
                    minDistance = dis;
                }
            }
            sum += minDistance;
            minDistance = Integer.MAX_VALUE; //초기화
        }
        return sum;
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
