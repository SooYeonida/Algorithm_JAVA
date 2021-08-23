package Problem.스택_큐;
import java.util.*;
public class LV2_프린터 {
    public int solution(int[] priorities, int location) {
        int answer = 0; //인쇄한 순서
        Queue<Docs> queue = new LinkedList<>();
        for(int i=0;i<priorities.length;i++){
            queue.add(new Docs(i,priorities[i]));
        }

        while(!queue.isEmpty()){
            Docs d = queue.poll();
            boolean check = false;
            for(int i=0;i<queue.size();i++){
                Docs tmp = queue.poll();
                if(d.priority<tmp.priority){
                    check = true;
                }
                queue.add(tmp);
            }
            if(check){
                queue.add(d);
            }
            else{
                answer++;
                if(d.index == location){
                    break;
                }
            }
        }

        return answer;
    }

    class Docs{
        int index;
        int priority;

        public Docs(int index,int priority){
            this.index = index;
            this.priority = priority;
        }
    }

}