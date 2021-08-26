package Problem.힙;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LV3_디스크컨트롤러_sol2 {
    public static void main(String[] args) {
        int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
        int answer = solution(jobs);
        System.out.println(answer);
    }

    static int solution(int[][] jobs) {
        int answer = 0;
        PriorityQueue<Job> waitQueue = new PriorityQueue<>(new Comparator<Job>() {
            @Override
            public int compare(Job o1, Job o2) {
                return o1.requestTime - o2.requestTime;
            }
        });
        PriorityQueue<Job> jobQueue = new PriorityQueue<>(new Comparator<Job>() {
            @Override
            public int compare(Job o1, Job o2) {
                return o1.workTime - o2.workTime;
            }
        });

        for(int i=0;i<jobs.length;i++){
            waitQueue.add(new Job(jobs[i][0],jobs[i][1]));
        }

        int now = 0; //현재 시간
        int cnt = 0; //처리한 작업 개수
        while(cnt<jobs.length){
            while(!waitQueue.isEmpty() && waitQueue.peek().requestTime <= now){
                jobQueue.add(waitQueue.poll());
            }

            System.out.println("now: "+now);
            if(!jobQueue.isEmpty()){
                Job job = jobQueue.poll();
                now += job.workTime;
                answer += now - job.requestTime;
                cnt++;
            }
            else{
                now++;
            }
        }

        answer = answer/ cnt;
        return answer;
    }

    static class Job{
        int requestTime;
        int workTime;
        public Job(int request, int work){
            this.requestTime = request;
            this.workTime = work;
        }
    }
}
