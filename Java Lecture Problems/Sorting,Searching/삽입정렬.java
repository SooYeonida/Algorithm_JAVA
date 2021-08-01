package Inflearn;

import java.util.Scanner;

public class 삽입정렬 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] array = new int[n];
        for(int i=0;i<array.length;i++){
            array[i] = in.nextInt();
        }

        for(int i=1;i<array.length;i++){
            int tmp = array[i];
            int j;
            for(j=i-1;j>=0;j--){
                if(array[j]>tmp){
                    array[j+1] = array[j];
                }
                else{
                    break;
                }
            }
            array[j+1] = tmp;
        }

        for(int a:array){
            System.out.print(a+" ");
        }

    }

}
