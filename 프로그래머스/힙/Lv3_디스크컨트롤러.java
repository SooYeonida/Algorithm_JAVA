package Problem.힙;
import java.util.*;

public class Lv3_디스크컨트롤러 {

        public int solution(int[][] jobs) {
            int answer = 0;
            int totalJobLength = 0;

            PriorityQueue<int[]> waitQueue = new PriorityQueue(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return (o1[0]>o2[0]) ? 1 : -1;
                }
            });

            PriorityQueue<int[]> jobQueue = new PriorityQueue(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return (o1[1]>o2[1]) ? 1 : (o1[1]<o2[1]) ? -1 : ((o1[0] > o2[0]) ? 1:-1);
                }
            });

            for (int i = 0; i < jobs.length; i++) {
                waitQueue.add(jobs[i]);
            }

            while (!waitQueue.isEmpty()) {
                while (!waitQueue.isEmpty() &&waitQueue.peek()[0] <= totalJobLength) {
                    jobQueue.offer(waitQueue.poll());
                }

                if (!jobQueue.isEmpty()) {
                    int[] job = jobQueue.poll();
                    totalJobLength += job[1];
                    answer += totalJobLength - job[0];
                } else {
                    totalJobLength++;
                }
            }

            //하나가 비어서 다시 돌림
            while (!jobQueue.isEmpty()) {
                int[] job = jobQueue.poll();
                totalJobLength += job[1];
                answer += totalJobLength - job[0];
            }

            return answer / jobs.length;
        }

}
