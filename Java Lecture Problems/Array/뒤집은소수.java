package Inflearn;

import java.util.Scanner;

public class 뒤집은소수 {
   public static void main(String[] args) {
       Scanner in = new Scanner(System.in);
       int n = in.nextInt();
       int[] arr = new int[n];

       for(int i=0;i<n;i++){
           String str = new StringBuilder(in.next()).reverse().toString();
           arr[i] = Integer.parseInt(str);
       }
       

       for(int a : arr){
           if(isPrime(a)) System.out.print(a+" ");
       }
    }
    
    static boolean isPrime(int num){
        if(num == 1) return false;
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
