package Programmers;

import java.util.*;
public class LV2_조이스틱 {
    public int solution(String name) {
        int answer = 0;
        int len = name.length();
        int min_move = len-1; //조이스틱을 움직여서 가질 수 있는 가장 큰 이동값 = 차례로 움직여서 len까지 가는 경우

        for(int i=0;i<len;i++){
            //알파벳 조작 값 계산
            answer += Math.min(name.charAt(i)-'A','Z'-name.charAt(i)+1);

            //최소 이동 값 계산
            int next = i+1;
            while(next<len&&name.charAt(next)=='A') next++;

            min_move = Math.min(min_move,i+len-next+i);
        }
        
        answer += min_move;

        return answer;
    }
}
