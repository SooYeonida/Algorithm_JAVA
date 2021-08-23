package Problem.힙;
import java.util.*;
public class LV2_더맵게_sol2 {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int answer = 0; //섞어야하는 최소횟수

        for(int sc : scoville){
            queue.add(sc);
        }

        while(!queue.isEmpty() && queue.size()>=2){
            int sc1 = queue.poll();
            int sc2 = queue.poll();

            if(sc1<K || sc2 <K){
                int newsc = sc1 + sc2*2 ;
                queue.add(newsc);
                answer++;
            }

            if(queue.size()==1){
                int sc = queue.poll();
                if(sc<K) answer = -1;
            }
        }

//         for(int i=0;i<scoville.length-1;i++){
//             if(scoville[i]<K || scoville[i+1]<K){
//                 int sc1 = Math.min(scoville[i],scoville[i+1]);
//                 int sc2 = Math.max(scoville[i],scoville[i+1]);
//                 int newsc = sc1 + (sc2*2);
//                 scoville[i+1] = newsc;
//                 answer++;

//                 if(i==scoville.length-1 && newsc < K){
//                     answer = -1;
//                 }
//             }
//         }

        return answer;
    }
}
