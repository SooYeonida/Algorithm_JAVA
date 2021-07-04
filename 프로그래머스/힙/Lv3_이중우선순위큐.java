package Problem.힙;
import java.util.*;

public class Lv3_이중우선순위큐 {
        public int[] solution(String[] operations) {

            ArrayList<Integer> instruction = new ArrayList<Integer>();

            for(int i=0;i<operations.length;i++){
                String[] split = operations[i].split(" ");
                if(operations[i].contains("I")){
                    instruction.add(Integer.parseInt(split[1]));
                    Collections.sort(instruction);//오름차순 정렬
                }
                else if(operations[i].contains("D")){
                    if(instruction.size()>=1&&Integer.parseInt(split[1]) == -1){
                        //최소값 삭제
                        instruction.remove(Collections.min(instruction));
                    }
                    else if(instruction.size()>=1&&Integer.parseInt(split[1]) == 1){
                        //최대값 삭제
                        instruction.remove(Collections.max(instruction));
                    }
                }
            }

            int[] answer = new int[2];

            if(!instruction.isEmpty()){
                answer[1] = Collections.min(instruction);
                answer[0] = Collections.max(instruction);
            }

            return answer;
        }
}
