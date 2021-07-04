package Problem.스택_큐;
import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;

public class Lv2_기능개발 {

        public int[] solution(int[] progresses, int[] speeds) {
            Queue<Integer> resultDay = new LinkedList<>(); //개발 완료까지 걸린 시간
            Stack<Integer> pushCnt = new Stack <>(); //배포 개수

            //개발 완료 시간 계산
            for(int i = 0; i<progresses.length;i++){
                int progress = 100 - progresses[i];
                int day = 0;
                while(progress>0){
                    progress -= speeds[i];
                    day ++;
                }
                resultDay.add(day);
            }

            //배포 개수 계산
            int first = -1;
            int cnt = 1;
            while(resultDay.size()!=0){
                int day = resultDay.poll();
                if(first<day){
                    //전의 날짜가 더 작은 경우 -> 같이 배포 x
                    cnt = 1;
                    first = day;
                }
                else{
                    //전의 날짜가 더 큰 경우
                    pushCnt.pop();
                }
                pushCnt.push(cnt++);
            }

            int[] answer = new int[pushCnt.size()];
            for(int i =answer.length-1;i>=0;i--){
                answer[i] = pushCnt.pop();
            }

            return answer;
        }
}
