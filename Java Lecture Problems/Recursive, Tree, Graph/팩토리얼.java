package Inflearn;

import java.util.Scanner;

public class 팩토리얼 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        System.out.println(factorial(n));
    }

    static int factorial(int n){
        if(n==1){
            return 1;
        }
        else{
            return n*=factorial(n-1);
        }
    }
}
