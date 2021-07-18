package Inflearn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 두배열합치기 {
    public static void main(String[] args) {
        //효율성이 높아야함.
        //퀵정렬의 경우 O(nlog)인데 이 문제의 경우 O(n)으로 짜라는 얘기.

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Integer> answer = new ArrayList<>();

//        for (int i = 0; i < n; i++) {
//            answer.add(in.nextInt());
//        }
//        int m = in.nextInt();
//        for (int i = 0; i < m; i++) {
//            answer.add(in.nextInt());
//        }
//        Collections.sort(answer);
//
//        O(nlogn) 풀이

        int[] a = new int[n];
        for(int i=0;i<n;i++){
            a[i] = in.nextInt();
        }
        int m = in.nextInt();
        int[] b = new int[m];
        for(int i=0;i<m;i++){
            b[i] = in.nextInt();
        }

        int p1=0,p2=0;
        while(p1<n && p2<m){
            if(a[p1]<b[p2]) answer.add(a[p1++]);
            else answer.add(b[p2++]);
        }
        while(p1<n) answer.add(a[p1++]);
        while(p2<m) answer.add(b[p2++]);

        for(int i : answer){
            System.out.printf("%d ",i);
        }

    }
}
