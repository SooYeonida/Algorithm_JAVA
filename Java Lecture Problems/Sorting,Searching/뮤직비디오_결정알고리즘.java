package Inflearn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class 뮤직비디오_결정알고리즘 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); //노래 개수
        int m = in.nextInt(); //dvd 1개에 들어가는 노래 개수

        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = in.nextInt();
        }

        int answer = -1;//녹화 가능한 최소 길이
        int rt = Arrays.stream(arr).sum();
        int lt = Arrays.stream(arr).max().getAsInt();
        //최소 용량 찾는 알고리즘
        /*
        lt rt사이에 찾고자하는 답이 있다고 확신하는 경우에만 결정 알고리즘을 적용 할 수 있음
        만약 내가 찾고자하는 답이 1-100사이에 있다하면 적용 가능.

        예시 입력의 경우
        Dvd 한장의 용량은 최소한 9는 되어야 9분짜리 하나는 넣을 수 있음. 따라서 lt=9;
        가장 큰 용량은 한장에 모든 노래를 다 담는 경우. 따라서 rt=45;
        */
        while(lt<=rt){
            int mid = (lt+rt)/2; //dvd한장의 용량
            if(count(arr,mid)<=m){
                answer = mid;
                rt = mid-1;
            }
            else{
                lt = mid+1;
            }
        }

        System.out.println(answer);
    }

    static int count(int[] arr, int capacity){
        //이 용량으로 dvd몇장이 필요한지
        int cnt = 1, sum=0;
        for(int x : arr){
            if(sum+x>capacity){
                cnt++;
                sum = x;
            }
            else sum += x;
        }
        return cnt;
    }
}
