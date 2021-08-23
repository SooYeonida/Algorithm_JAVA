package Problem.정렬;
import java.util.*;
public class LV1_K번째수_sol2 {
    public int[] solution(int[] array, int[][] commands) {

        int[] answer = new int[commands.length];

        for(int i=0;i<commands.length;i++){
            int[] tmp;
            tmp = Arrays.copyOfRange(array,commands[i][0]-1,commands[i][1]);

            Arrays.sort(tmp);

            answer[i] = tmp[commands[i][2]-1];
        }

        return answer;
    }
}
