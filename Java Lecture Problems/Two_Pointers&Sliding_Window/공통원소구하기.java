package Inflearn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class 공통원소구하기 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] array1 = new int[n];
        for(int i=0;i<n;i++){
            array1[i] = in.nextInt();
        }
        int m = in.nextInt();
        int[] array2 = new int[m];
        for(int i=0;i<m;i++){
            array2[i] = in.nextInt();
        }

        Arrays.sort(array1);
        Arrays.sort(array2);
        int p1=0,p2=0;
        ArrayList<Integer> list = new ArrayList<>();
        while(p1<n&&p2<m){
            if(array1[p1]>array2[p2]){
                p2++;
            }
            else if(array1[p1]<array2[p2]){
                p1++;
            }
            else{
                //같은 경우
                list.add(array1[p1]);
                p1++;
                p2++;
            }
        }

        for(int a : list)
        System.out.printf("%d ",a);

    }
}
