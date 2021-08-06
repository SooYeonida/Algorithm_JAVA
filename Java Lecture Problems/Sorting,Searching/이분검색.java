package Inflearn;

import java.util.*;

public class 이분검색 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); //숫자 개수
        int m = in.nextInt(); //찾을 숫자

        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(in.nextInt());
        }
        Collections.sort(list);

        //12 23 32 57 65 81 87 99

        System.out.println(list.indexOf(m)+1);

    }
}
