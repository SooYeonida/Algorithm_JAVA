package Inflearn;

import java.util.Scanner;

public class 소수_에라토스테네스체 {
    //에라토스테네스체가 소수구하는 방법에서 제일 빠름
    //이중포문은 느림

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ch = new int[n+1];
        int count = 0;

        //소수 -> 약수가 1과 자기자신인 수 (1제외)
        for(int i=2;i<=n;i++){
            if(ch[i]==0){
                count++;
                for(int j=0;j<=n;j=j+i){
                    //i의 배수를 찾아야하니까 i만큼 증가
                    ch[j] = 1;
                }
            }
        }

        System.out.println(count);
    }
}
