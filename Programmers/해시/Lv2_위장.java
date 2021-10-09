package Problem.해시;
import java.util.*;

public class Lv2_위장 {
       public int solution(String[][] clothes) {
        HashMap<String,Integer> map = new HashMap<>();
        
         for(int i=0;i<clothes.length;i++){
             map.put(clothes[i][1],map.getOrDefault(clothes[i][1],0)+1);
        }
        
        //경우의 수 
        int answer = 1;
        for(String key : map.keySet()){
            System.out.println(map.get(key));
            answer *= (map.get(key)+1); //+1 : 아예 안입는 경우 
        }
        return answer-1; //모든 타입의 의상을 안입는 경우 -1 
    }
}
