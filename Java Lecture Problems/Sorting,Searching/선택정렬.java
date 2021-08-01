package Inflearn;

import java.util.Scanner;

public class 선택정렬 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] array = new int[n];
        for(int i=0;i<n;i++){
            array[i] = in.nextInt();
        }

        int tmp;
        for(int i=0;i<array.length;i++){
            int min_index = i;
            for(int j=i;j<array.length;j++){
                if(array[j]<array[min_index]){
                    min_index = j;
                }
            }
            tmp = array[min_index];
            array[min_index] = array[i];
            array[i] = tmp;
        }

        for(int a : array){
            System.out.print(a+" ");
        }

    }
}
