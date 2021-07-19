package Inflearn;

import java.util.HashMap;
import java.util.Scanner;

public class 학급회장 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        char[] array = in.next().toCharArray();

        HashMap<Character,Integer> hashMap = new HashMap<>();
        for(int i=0;i<n;i++){
//            if(hashMap.containsKey(array[i])){
//                int cnt = hashMap.get(array[i]);
//                cnt++;
//                hashMap.put(array[i],cnt);
//            }
//            else{
//                int cnt=1;
//                hashMap.put(array[i],cnt++);
//            }
//            이렇게 길게 체크할 필요 없이

            hashMap.put(array[i],hashMap.getOrDefault(array[i],0)+1);
        }
        
        int max = Integer.MIN_VALUE;
        char answer = ' ';
        for(char key :hashMap.keySet()) {
            //System.out.println("key : "+key+ " ->"+hashMap.get(key));
            if(max<hashMap.get(key)){
                max = hashMap.get(key);
                answer = key;
            }
        }

        System.out.println(answer);
    }
}
