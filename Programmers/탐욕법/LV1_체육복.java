package Problem.탐욕법;
import java.util.*;
public class LV1_체육복 {

    /*
    고려안했던 부분 기존 코드는 index 2부터 검색해서 이전 index의 value 값이 0인지만 확인했음.
    이런 경우 1 :o 2: x일때는 세지 않음. 따라서 양경우를 비교해줘야함.
    */
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int s : reserve){
            map.put(s,2);
        }

        for(int s : lost){
            if(map.containsKey(s)){
                map.put(s,map.get(s)-1);
            }
            else{
                map.put(s,0);
            }
        }

        if(n!=(lost.length+reserve.length)){
            for(int i=1;i<=n;i++){
                if(!map.containsKey(i)){
                    map.put(i,1);
                }
            }
        }

        for(int i=2;i<=map.size();i++){
            if(map.get(i-1)==0 && map.get(i)>=2){
                map.put(i-1,1);
                map.put(i,1);
                continue;
            }
            else if(map.get(i-1)>=2 && map.get(i)==0){
                map.put(i-1,1);
                map.put(i,1);
                continue;
            }
        }

        for(int i = 1;i<=map.size();i++){
            if(map.get(i)>0) answer++;
        }
        return answer;
    }
}
