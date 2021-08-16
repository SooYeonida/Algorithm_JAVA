package Inflearn;

public class week1_부족한금액계산하기 {
        public long solution(int price, int money, int count) {
            long answer = -1;
            //금액이 부족하지 않으면 0 return

            long total = 0;
            long sum = 0;

            for(int i=0;i<count;i++){
                sum += price;
                total += sum;
            }

            answer = total - money;
            if(answer<=0){
                answer = 0;
            }

            return answer;
        }
}
