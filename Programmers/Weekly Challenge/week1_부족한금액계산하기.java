package Inflearn;

public class week1_부족한금액계산하기 {
        public long solution(int price, int money, int count) {
        long answer = money;
        long sum = 0;
        
        for(int i=0;i<count;i++){
            sum += price;
            answer -= sum;
        }
    
        if(answer>=0){
            answer = 0;
        }

        return Math.abs(answer);
    }
}
