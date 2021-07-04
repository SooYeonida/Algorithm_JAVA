package Problem.해시;
import java.util.*;

public class Lv2_위장 {

        public int solution(String[][] clothes) {
            int answer = 1;
            HashMap<String,Integer> hashMap = new HashMap<>();

            for(String[]clothe : clothes){
                //초기값 설정
                if(!hashMap.keySet().contains(clothe[1])){
                    hashMap.put(clothe[1],1);
                }
                else{
                    //값 증가
                    int entry = hashMap.get(clothe[1]);
                    hashMap.put(clothe[1],++entry);
                }
            }

            for(String key : hashMap.keySet()){
                answer *= (hashMap.get(key) + 1);
            }
            answer --;

            return answer;
        }
}
