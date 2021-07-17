package Problem.힙;
import java.util.PriorityQueue;

public class Lv2_더맵게 {

        int answer = 0;
        public int solution(int[] scoville, int K) {

            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

            for(int i=0;i<scoville.length;i++){
                priorityQueue.add(scoville[i]);
            }


            while(priorityQueue.size()>1){
                if(priorityQueue.peek()>=K){
                    break;
                }
                else{
                    int mixFood = mix(priorityQueue.poll(),priorityQueue.poll());
                    priorityQueue.add(mixFood);
                }
            }

            if(priorityQueue.size()==1){
                if(priorityQueue.peek()<K){
                    answer = -1;
                }
            }

            return answer;
        }

        public int mix(int food1, int food2){
            answer++;
            return food1 + (food2*2);
        }
}
