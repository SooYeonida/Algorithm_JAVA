package Problem.완전탐색;
import java.util.*;

public class Lv2_카펫 {

        public int[] solution(int brown, int yellow) {
            //가로, 세로
            int[] answer = new int[2];
            int totalNum = brown+yellow;

            int num1 = 0;
            int num2 = 0;

            for(int i=3;i<totalNum;i++){
                if(totalNum % i ==0){
                    num1 = totalNum/i;
                    num2 = totalNum/num1;

                    if((num1-2)*(num2-2) == yellow && num1>=num2){
                        break;
                    }
                }
            }


            answer[0] = num1;
            answer[1] = num2;
            return answer;
        }
}
