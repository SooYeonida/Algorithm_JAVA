package Inflearn;

import java.util.Scanner;

public class 등수구하기 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] socre = new int[n];
        for(int i =0;i<n;i++){
            socre[i] = in.nextInt();
        }

        int[] answer = new int[n];
        int cnt = 1;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(socre[j]>socre[i]){
                    cnt++;
                }
            }
            answer[i] = cnt;
            cnt=1;
        }

        for(int i=0;i<n;i++){
            System.out.printf("%d ",answer[i]);
        }
    }
}
