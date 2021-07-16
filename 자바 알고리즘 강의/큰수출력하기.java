package Inflearn;

import java.util.Scanner;

public class 큰수출력하기 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] array = new int[n];
        String answer = "";

        for(int i=0;i<n;i++){
            array[i] = in.nextInt();
        }

        answer += array[0]+" ";
        for(int i=1;i<n;i++){
             if(array[i]>array[i-1]){
                 answer+=array[i]+" ";
             }
        }
        System.out.println(answer);
    }
}
