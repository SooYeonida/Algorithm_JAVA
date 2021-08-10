package Inflearn;

import java.util.Scanner;

public class 재귀함수_스택프레임 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        printNum(n);
    }

    static void printNum(int n){
        if(n==1){
            System.out.print(n+" ");
        }
        else{
            printNum(n-1);
            System.out.print(n+" ");
        }
    }
}
