package Problem.스택_큐;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LV2_기능개발_sol2 {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();

        for(int i=0;i<progresses.length;i++){
            if((100 - progresses[i])%speeds[i] != 0){
                queue.add((100 - progresses[i])/speeds[i]+1);
            }
            else{
                queue.add((100 - progresses[i])/speeds[i]);
            }
        }

        int bj = -1;
        int count = 0;
        while(!queue.isEmpty()){
            if(bj==-1){
                bj = queue.poll();
                count++;
            }
            else{
                int aj = queue.poll();
                if(bj>=aj){
                    count++;
                }
                else{
                    result.add(count);
                    count = 1;
                    bj = aj;
                }

            }

            if(queue.isEmpty()){
                result.add(count);
            }

        }

        answer = new int[result.size()];
        for(int i=0;i<result.size();i++){
            answer[i] = result.get(i);
        }
        return answer;
    }
}
