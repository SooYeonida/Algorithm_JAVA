package Inflearn;

import java.util.Scanner;

public class 피보나치수열 {

    //문제에서 재귀를 원하는게 아니라 time limit exceeded
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        for(int i=0;i<n;i++)
//            System.out.printf("%d ",fibonacci(i));
//    }
//
//    public static int fibonacci(int c){
//        if(c==0 || c==1){
//            return 1;
//        }
//        return fibonacci(c-1)+fibonacci(c-2);
//    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] fibonacci = new int[n];
        for(int i=0;i<n;i++){
            if(i<=1){
                fibonacci[i] = 1;
                System.out.printf("%d ",fibonacci[i]);
            }
            else{
                fibonacci[i] = fibonacci[i-2] + fibonacci[i-1];
                System.out.printf("%d ",fibonacci[i]);
            }
        }
    }
}
