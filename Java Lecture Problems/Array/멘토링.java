package Inflearn;

import java.util.Scanner;

public class 멘토링 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int studentNum = in.nextInt();
        int testNum = in.nextInt();

        int [][] array = new int[testNum][studentNum];
        for(int i=0;i<testNum;i++){
            for(int j=0;j<studentNum;j++){
                array[i][j] = in.nextInt();
            }
        }

        int answer = 0;
        for(int i=1;i<=studentNum;i++){
            for(int j=1;j<=studentNum;j++){ //i,j는 학생 조합이라고 생각.
                int cnt =0;
                for(int k=0;k<testNum;k++){ //test
                    int pi =0, pj =0;
                    for(int s=0;s<studentNum;s++){
                        if(array[k][s] == i){
                            pi = s;
                        }
                        if(array[k][s]==j){
                            pj = s;
                        }
                    }
                    if(pi<pj) cnt++;
                }
                if(cnt == testNum){
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}
