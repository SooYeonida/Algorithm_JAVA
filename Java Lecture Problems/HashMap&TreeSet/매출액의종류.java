package Inflearn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class 매출액의종류 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();

        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = in.nextInt();
        }

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        ArrayList<Integer> answer = new ArrayList<>();
//        int lt = 0, cnt = 0;
//        HashMap<Integer, Integer> hashMap = new HashMap<>();
//        for (int rt = 0; rt < n; rt++) {
//            hashMap.put(array[rt], hashMap.getOrDefault(array[rt], 0) + 1);
//            cnt++;
//            if (cnt == k) {
//                System.out.printf("%d ", hashMap.size());
//                hashMap.put(array[lt], hashMap.get(array[lt]) - 1);
//                if (hashMap.get(array[lt]) == 0) {
//                    hashMap.remove(array[lt]);
//                }
//                lt++;
//                cnt--;
//            }
//        }
//        for문한번 도는데 왜 time exceed인지..

        for(int i=0;i<k-1;i++){
            hashMap.put(array[i],hashMap.getOrDefault(array[i],0)+1);
        }
        int lt=0;
        for(int rt=k-1;rt<n;rt++){
            hashMap.put(array[rt],hashMap.getOrDefault(array[rt],0)+1);
            //System.out.printf("%d ",hashMap.size());
            answer.add(hashMap.size());
            hashMap.put(array[lt],hashMap.get(array[lt])-1);
            if(hashMap.get(array[lt])==0){
                hashMap.remove(array[lt]);
            }
            lt++;
        }

        for(int a : answer){
            System.out.print(a+" ");
        }

    }
}
