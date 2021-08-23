package Problem.완전탐색;

import java.util.ArrayList;
import java.util.*;
public class LV1_모의고사_sol2 {
    public int[] solution(int[] answers) {
        int[] pattern_a = {1,2,3,4,5};
        int[] pattern_b = {2,1,2,3,2,4,2,5};
        int[] pattern_c = {3,3,1,1,2,2,4,4,5,5};

        int[] index = new int[3];
        int[] count = new int[3];

        for(int n : answers){
            if(n == pattern_a[index[0]++%pattern_a.length]) count[0]++;
            if(n == pattern_b[index[1]++%pattern_b.length]) count[1]++;
            if(n == pattern_c[index[2]++%pattern_c.length]) count[2]++;
        }


        int max = Math.max(count[0],Math.max(count[1],count[2]));

        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<3;i++){
            if(max == count[i]){
                list.add(i+1);
            }
        }

        int[] answer = new int[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}
