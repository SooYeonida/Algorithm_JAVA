package Inflearn;

import java.util.Scanner;

public class 부분집합구하기_DFS {

    static int[] check;
    static int n;

    static void DFS(int L){
        if(L==n+1){
            String tmp = "";
            for(int i=1;i<=n;i++){
                if(check[i]==1){
                    tmp += (i+" ");
                }
            }
            if(tmp.length()>0) System.out.println(tmp);
        }
        else{
           check[L] = 1;
           DFS(L+1); //왼쪽 - 사용o

           check[L] = 0;
           DFS(L+1); //오른쪽 - 사용x
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        check = new int[n+1]; //check의 index번호를 원소로 생각해서.

        DFS(1);

        /*
       1 2 3
       1 2
       1 3
       1
       2 3
       2
       3
         */

    }
}
