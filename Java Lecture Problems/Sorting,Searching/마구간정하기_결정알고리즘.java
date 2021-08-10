package Inflearn;

import java.util.Arrays;
import java.util.Scanner;

public class 마구간정하기_결정알고리즘 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); //마구간 수
        int c = in.nextInt(); //말 수

        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = in.nextInt();
        }

        Arrays.sort(arr);

        //헷갈린 포인트 : 이분검색에서 mid 판단을 어떤 기준으로 해야하는지
        int lt=1, rt= arr[n-1];
        int answer = -1;
        while(lt<=rt){
            int mid = (lt+rt)/2;
            if(count(arr,mid)>=c){
                answer = mid;
                lt = mid+1;
            }
            else{
                rt = mid-1;
            }
        }

        System.out.println(answer);
    }

    static int count(int[] arr,int distance){
        int cnt = 1; //배치한 말의 수
        int ep = arr[0]; //젤 왼쪽 좌표에다 말 배치
        for(int i=1;i<arr.length;i++){
            if(arr[i]-ep>=distance){
                cnt++;
                ep = arr[i];
            }
        }
        return cnt;
    }
}
