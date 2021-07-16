package Inflearn;

import java.util.Scanner;

public class 뒤집은소수 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] array = new String[n];

        for(int i=0;i<n;i++){
            array[i] = in.next();
        }

        for(int i=0;i<n;i++){
            StringBuilder sb = new StringBuilder(array[i]);
            int num = Integer.parseInt(sb.reverse().toString());

            if(isPrime(num)){
                System.out.printf("%d ",num);
            }
            //while(tmp>0){
            //int t = tmp%10;
            //res =res*10 + t;
            //tmp = tmp/10;
            //라이브러리 못쓸때는 이런식으로 뒤집기

        }
    }

    public static boolean isPrime(int num){
        if(num ==1) return false;
        else{
            for(int i=2;i<num;i++){
                if(num%i==0){
                    return false;
                }
            }
        }
        return true;
    }
}
