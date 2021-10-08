package Inflearn;

import java.util.Scanner;

public class 소수_에라토스테네스체 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
       int n = in.nextInt();

       int[] arr = new int[n+1];

       int count = 0;
       for(int i=2;i<=n;i++){
           if(arr[i]==0) {
               count++;
               for (int j = i * i; j <= n; j = j + i) {
                   arr[j] = 1;
               }
           }
       }

        System.out.println(count);
    }
}
