package Inflearn;

import java.util.Scanner;

public class 보이는학생 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] students = new int[n];

        for(int i=0;i<n;i++){
            students[i] = in.nextInt();
        }

        int count = 1;
        int max = students[0];
        for(int i=1;i<n;i++){
            if(max<students[i]){
                max = students[i];
                count++;
            }
        }

        System.out.println(count);
    }
}
