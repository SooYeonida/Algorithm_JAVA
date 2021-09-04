package Inflearn;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class 최대부분증가수열 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); //숫자 개수
        int[] arr = new int[n]; //숫자 배열
        Integer[] dy = new Integer[n]; //i번째 숫자를 마지막항으로 하는 최대 증가수열의 길이 담는 배열

        for(int i=0;i<n;i++){
            arr[i] = in.nextInt();
        }

        for(int i=0;i<n;i++){
            int maxLength = 0;
            for(int j = i;j>=0;j--){
                //감소하며 비교
                if(arr[i]>arr[j]){
                    if(maxLength<dy[j]){
                        maxLength = dy[j];
                    }
                }
            }
            dy[i] = maxLength + 1;
        }

        Arrays.sort(dy,Collections.reverseOrder());
        System.out.println(dy[0]);
    }

}
