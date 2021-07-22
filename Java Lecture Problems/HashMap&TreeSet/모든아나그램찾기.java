package Inflearn;

import java.util.HashMap;
import java.util.Scanner;

public class 모든아나그램찾기 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String t = in.next(); //t.length <= s.length

        HashMap<Character,Integer> tHash = new HashMap<>();
        for(int i=0;i<t.length();i++){
            tHash.put(t.charAt(i),tHash.getOrDefault(t.charAt(i),0)+1);
        }

//        int lt=0, cnt=0,answer=0;
//        HashMap<Character,Integer> sHash = new HashMap<>();
//        for(int rt =0;rt<s.length();rt++){
//            sHash.put(s.charAt(rt),sHash.getOrDefault(s.charAt(rt),0)+1);
//            cnt++;
//            if(cnt == tHash.size()){
//                if(sHash.equals(tHash)) answer++;
//                sHash.put(s.charAt(lt),sHash.get(s.charAt(lt))-1);
//                if(sHash.get(s.charAt(lt))==0){
//                    sHash.remove(s.charAt(lt));
//                }
//                lt++;
//                cnt--;
//            }
//        }

        int L = t.length()-1;
        HashMap<Character,Integer> sHash = new HashMap<>();
        int answer = 0;
        for(int i=0;i<L;i++){
            sHash.put(s.charAt(i),sHash.getOrDefault(s.charAt(i),0)+1);
        }
        int lt=0;
        for(int rt=L;rt<s.length();rt++){
            sHash.put(s.charAt(rt),sHash.getOrDefault(s.charAt(rt),0)+1);
            if(sHash.equals(tHash)) answer++;
            sHash.put(s.charAt(lt),sHash.get(s.charAt(lt))-1);
            if(sHash.get(s.charAt(lt))==0) sHash.remove(s.charAt(lt));
            lt++;
        }
        System.out.print(answer);

    }
}
//am.equals(bm) : 이렇게 해쉬맵 자체 키랑 밸류값도 equals로 비교 가능
