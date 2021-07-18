package Inflearn;

import java.util.Scanner;

public class 최대길이연속부분수열 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); //수열의 길이
        int m = in.nextInt(); //1로 바꿀 수 있는 개수

        int[] array = new int[n];
        for(int i=0;i<n;i++){
            array[i] = in.nextInt();
        }

        int lt=0,cnt=0, answer =0;
        for(int rt=0;rt<n;rt++){
            if(array[rt]==0){
                cnt++;
                while(m<cnt){
                    if(array[lt]==0){
                        cnt--;
                    }
                    lt++;
                }
            }
            answer = Math.max(answer,rt-lt+1);
        }

        System.out.println(answer);
    }
}
