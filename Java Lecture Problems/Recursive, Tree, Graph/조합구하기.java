package Inflearn;

import java.util.Scanner;

public class 조합구하기 {
    /*
    1부터 N까지 번호가 적힌 구슬이 있습니다. 이 중 M개를 뽑는 방법의 수를 출력하는 프로그램을 작성하세요.

    입력설명
    첫번째줄에 자연수 N(3<=N<=10)과 M(2<=M<=N)이 주어집니다.

    출력설명
    첫번째줄에 결과를 출력합니다.
    출력순서는 사전순으로 오름차순으로 출력합니다.

    입력예제
    4 2

    출력예제
    1 2
    1 3
    1 4
    2 3
    2 4
    3 4
     */

    static int n;
    static int m;
    static int[] combi;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        combi = new int[m];

        dfs(0,1);
    }

    //중복 조합
//    static void dfs(int L,int start){
//        if(L==m){
//            for(int a : combi){
//                System.out.print(a+" ");
//            }
//            System.out.println();
//        }
//        else{
//            for(int i=start;i<=n;i++){
//                combi[L] = i;
//                dfs(L+1,i);
//            }
//        }
//    }


    //조합
        static void dfs(int L,int start){
        if(L==m){
            for(int a : combi){
                System.out.print(a+" ");
            }
            System.out.println();
        }
        else{
            for(int i=start;i<=n;i++){
                combi[L] = i;
                dfs(L+1,i+1);
            }
        }
    }


}
