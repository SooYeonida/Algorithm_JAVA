package Inflearn;

import java.util.Scanner;

public class 점수계산 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] array = new int[n];

        for(int i=0;i<n;i++){
            array[i] = in.nextInt();
        }

//        int appearNum = 1;
//        int total = 0;
//        if(array[0]==1) total = 1;
//        for(int i=1;i<n;i++){
//            if(array[i]==1){
//                if(array[i]==array[i-1]){
//                    appearNum++;
//                    total += appearNum;
//                }
//                else{
//                    appearNum = 1;
//                    total++;
//                }
//            }
//        } 밑이 좀더 간단한 버전

        int appearNum = 0;
        int total = 0;
        for(int i=0;i<n;i++){
            if(array[i]==1){
                appearNum++;
                total += appearNum;
            }
            else{
                appearNum = 0;
            }
        }
        System.out.println(total);
    }
}
