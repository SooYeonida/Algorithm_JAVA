package Inflearn;

import java.util.Scanner;

public class 가위바위보 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] game = new int[n][n];

        for(int i=0;i<2;i++){
            for(int j=0;j<n;j++){
                game[i][j] = in.nextInt();
            }
        }
   //가위 1 바위 2 보 3
        for(int i=0;i<n;i++){
            if(game[0][i]==game[1][i]){
                //비긴 경우
                System.out.println("D");
            }
            else{
                if(game[0][i]==1){
                    if(game[1][i]==2){
                        System.out.println("B");
                    }
                    else{
                        System.out.println("A");
                    }
                }
                else if(game[0][i]==2){
                    if(game[1][i]==1){
                        System.out.println("A");
                    }
                    else{
                        System.out.println("B");
                    }
                }
                else{
                    if(game[1][i]==1){
                        System.out.println("B");
                    }
                    else{
                        System.out.println("A");
                    }
                }

            }
        }
    }
}
