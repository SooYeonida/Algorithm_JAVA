package Inflearn;

import java.util.Scanner;

public class 버블정렬 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] array = new int[n];
        for(int i=0;i<n;i++){
            array[i] = in.nextInt();
        }

        for(int i=array.length-1;i>=0;i--){
            for(int j=0;j<i;j++){
                if(array[j]>array[j+1]){
                    int tmp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = tmp;

                }
            }
        }

        for(int a: array){
            System.out.print(a+" ");
        }

    }
}
