package Problem.정렬;
import java.util.*;
public class LV2_가장큰수_sol2 {
    public String solution(int[] numbers) {
        String answer = "";

        int zeroCount = 0;
        ArrayList<String> list = new ArrayList<>();
        for(int n :numbers){
            if(n==0) zeroCount++;
            list.add(String.valueOf(n));
        }

        if(zeroCount==list.size()) return "0";

        Comparator<String> comparator = new Comparator<String>(){
            @Override
            public int compare(String o1,String o2){
                return (o2+o1).compareTo(o1+o2);
            }
        };
        Collections.sort(list,comparator);

        for(String s: list){
            answer+=s;
        }

        return answer;
    }
}
