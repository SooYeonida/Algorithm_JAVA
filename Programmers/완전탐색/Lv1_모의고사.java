package Problem.완전탐색;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Lv1_모의고사 {

        public int[] solution(int[] answers) {

            int[]pattern_first = new int[]{1, 2, 3, 4, 5};
            int[]pattern_second = new int[]{ 2, 1, 2, 3, 2, 4, 2, 5};
            int[]pattern_third = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

            int[] num_of_answer = new int[3];

            ArrayList<Integer> best = new ArrayList<>();

            for(int i=0;i<answers.length;i++){
                if(answers[i] == pattern_first[i%pattern_first.length]){
                    num_of_answer[0]++;
                }
                if(answers[i] == pattern_second[i%pattern_second.length]){
                    num_of_answer[1]++;
                }
                if(answers[i] == pattern_third[i%pattern_third.length]){
                    num_of_answer[2]++;
                }
            }

            int max = Arrays.stream(num_of_answer).max().getAsInt();

            for(int i =0;i<num_of_answer.length;i++) {
                if(max == num_of_answer[i]){
                    best.add(i+1);
                }
            }
            Collections.sort(best);

            return best.stream().mapToInt(Integer::intValue).toArray();
        }

}
