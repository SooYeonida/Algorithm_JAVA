package Inflearn;

import java.util.Scanner;

public class 임시반장정하기 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] array = new int[n][5];
        int[] chart = new int[n];

        for(int i=0;i<n;i++){
            for(int j=0;j<5;j++){
                array[i][j] = in.nextInt();
            }
        }

//        int index = 0;
//        while(index<n) {
//            for (int i = 0; i < 5; i++) {
//                int target = array[index][i];
//                for (int j = 0; j < n; j++) {
//                    if(target == array[j][i]){
//                        chart[index] ++;
//                    }
//                }
//            }
//            index++;
//        }
//         오답이 나온 이유 -> 같은반이였던 횟수가 아니라 학생 수를 세는건데
//         chart[index]++해서 횟수를 세고 있었음.
//        세로로 비교하는게 아니라 가로로 비교해서 같은 학생에 대해서 두번세는걸 방지하기 위해 break걸어줘야함.

        int answer = 0;
        int max = Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            int cnt = 0;
            for(int j=0;j<n;j++){
                for(int k=0;k<5;k++){
                    if(array[i][k]==array[j][k]){
                        cnt++;
                        break;
                    }
                }
            }
            if(cnt>max){
                max=cnt;
                answer=i;
            }
        }

        System.out.println(answer+1);
    }
}

