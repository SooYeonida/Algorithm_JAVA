package Problem.정렬;

import java.util.Arrays;
public class Lv1_K번째수 {
        public int[] solution(int[] array, int[][] commands) {
            int[] answer = new int [commands.length];
            for(int i =0;i<commands.length;i++){

                int[] command = commands[i];
                int first = command[0]-1;
                int last = command[1]-1;
                int peek = command[2]-1;
                int[] tmp_array = new int[last-first+1];

                System.arraycopy(array,first,tmp_array,0,last-first+1);

                Arrays.sort(tmp_array); //오름차순 정렬
                answer[i] = tmp_array[peek];
            }
            return answer;
        }
}
