package BOJ;

import java.util.Scanner;

public class 시험감독 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); //시험장 개수
        long[] arr = new long[n]; //시험장 인원
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        long b = in.nextInt(); //총감독관 응시자 수
        long c = in.nextInt(); //부감독관 응시자 수

        //총 감독관은 반드시 한명

        long answer = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] >= b) {
                arr[i] = arr[i] - b;
                answer++;

                if(arr[i]>0){
                    answer += arr[i]/c;
                    if(arr[i]%c>0) answer++;
                }
            } else {
                answer++;
            }
        }

        System.out.print(answer);

    }
}
