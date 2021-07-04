package Problem.정렬;

import java.util.Arrays;
public class Lv2_H_Index {
        public int solution(int[] citations) {
            int answer = 0;

            Arrays.sort(citations);

            answer = citations[citations.length / 2];

            while (true) {
                int mid_up = 0;
                int mid_down = 0;
                for (int i = 0; i < citations.length; i++) {
                    if (citations[i] >= answer) {
                        mid_up++;
                    } else {
                        mid_down++;
                    }
                }

                if (mid_up >= answer && answer >= mid_down) {
                    break;
                } else {
                    answer--;
                }
            }

            return answer;
        }
}
