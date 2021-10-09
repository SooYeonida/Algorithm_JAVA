package Programmers;

import java.util.*;
public class LV2_다리를지나는트럭 {
        public int solution(int bridge_length, int weight, int[] truck_weights) {
            Queue<Integer> bridge = new LinkedList<>();
            int answer = 0;
            int sum = 0;

            for (int i = 0; i < truck_weights.length; i++) {
                int truck = truck_weights[i];
                while (true) {
                    if (bridge.isEmpty()) {
                        //다리 비어있는 경우
                        sum += truck;
                        answer++;
                        bridge.offer(truck);
                        break;
                    } else if (bridge.size() < bridge_length) {
                        //가득차지 않은 경우 
                        if (sum + truck <= weight) {
                            sum += truck;
                            answer++;
                            bridge.offer(truck);
                            break;
                        } else {
                            bridge.offer(0);
                            answer++;
                        }
                    } else if (bridge.size() == bridge_length) {
                        //가득찬 경우
                        sum -= bridge.poll();
                    }

                }
            }
            return answer + bridge_length;
        }
}
