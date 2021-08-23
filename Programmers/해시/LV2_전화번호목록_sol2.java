package Problem.해시;

import java.util.*;
public class LV2_전화번호목록_sol2 {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        ArrayList<String> list = new ArrayList<>();
        for(String pn: phone_book){
            list.add(pn);
        }

        Collections.sort(list);

        boolean tag = true;
        for(int i=0;i<list.size()-1;i++){
            for(int j=0;j<list.get(i).length();j++){
                if(list.get(i).charAt(j) == list.get(i+1).charAt(j)){
                    tag = true;
                }
                else{
                    tag = false;
                    break;
                }
            }
            if(tag){
                answer = false;
                break;
            }
            else{
                answer = true;
            }
        }
        return answer;
    }
}
