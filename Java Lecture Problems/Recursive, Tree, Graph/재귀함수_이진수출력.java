package Inflearn;

import java.util.Scanner;

public class 재귀함수_이진수출력 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        binary(n);
    }

    static void binary(int n){
        if(n!=0) {
            binary(n / 2);
            System.out.print(n%2);
        }
    }
}
