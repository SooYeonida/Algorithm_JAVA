package Inflearn;

import java.util.Arrays;
import java.util.Scanner;

public class 중복확인 {
    public static void main(String[] args) {
        //해시로 풀면 O(n)
        //정렬로 풀면 O(nlogn)

        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] students = new int[N];
        for(int i=0;i<N;i++){
            students[i] = in.nextInt();
        }

        Arrays.sort(students); //nlogn 걸림

        boolean answer = true;

        for(int i=0;i<students.length-1;i++){
            if(students[i]==students[i+1]){
                answer = false;
                break;
            }
        }

        if(answer)
        System.out.println("U");
        else
            System.out.println("D");
    }

}
