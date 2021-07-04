package Problem.해시;
import java.util.*;

public class Lv1_완주하지못한선수 {

        public String solution(String[] participant, String[] completion) {
            String answer = "";
            HashMap<String,Integer> comple = new HashMap();

            for (String person : participant){
                comple.put(person, comple.getOrDefault(person, 0) + 1);
            }

            for (String person : completion){
                comple.put(person, comple.get(person) - 1);
            }

            for (String key : comple.keySet()) {
                if (comple.get(key) != 0){
                    answer = key;
                    break;
                }
            }

            return answer;
        }
}
