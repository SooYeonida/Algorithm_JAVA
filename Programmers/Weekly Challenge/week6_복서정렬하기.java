package Programmers;

import java.util.*;

public class week6_복서정렬하기 {
    public int[] solution(int[] weights, String[] head2head) {
        ArrayList<Boxer> list = new ArrayList<>();

        for (int i = 0; i < head2head.length; i++) {
            char[] game = head2head[i].toCharArray();
            int heavy_win = 0;
            Double win = 0.0;
            int count = 0;
            Boxer boxer = new Boxer(i, weights[i]);

            for (int j = 0; j < game.length; j++) {
                if (i != j) {
                    if (game[j] == 'W') {//i복서가 j복서를 이겼음
                        if (weights[i] < weights[j]) heavy_win++;
                        win++;
                        count++;
                    } else if (game[j] == 'L') {//i복서가 j복서에게 졌음
                        count++;
                    }
                }
            }
            boxer.heavy_win = heavy_win;
            if (count != 0) win = (win / count) * 100;
            boxer.win = win;
            list.add(boxer);
        }

        Collections.sort(list);

        int[] answer = new int[list.size()];
        int index = 0;
        for (Boxer b : list) {
            answer[index++] = b.num + 1;
        }
        return answer;
    }

    static class Boxer implements Comparable<Boxer> {
        @Override
        public int compareTo(Boxer o) {
            if (o.win.compareTo(this.win) == 0) {
                if (o.heavy_win == this.heavy_win) {
                    if (o.weight == this.weight) {
                        return this.num - o.num;
                    }
                    return o.weight - this.weight;
                }
                return o.heavy_win - this.heavy_win;
            }
            return o.win.compareTo(this.win);
        }

        int num;//번호
        Double win = 0.0;//승률
        int weight;
        int heavy_win = 0;//자신보다 무거운 선수를 이긴 횟수

        public Boxer(int num, int weight) {
            this.num = num;
            this.weight = weight;
        }
    }
}
