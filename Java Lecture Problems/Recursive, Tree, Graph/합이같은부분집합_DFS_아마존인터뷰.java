package Inflearn;

import java.util.Scanner;

public class 합이같은부분집합_DFS_아마존인터뷰 {
    static String answer = "NO";
    static boolean flag = false;
    static int total = 0;
    static int n;
    static int[] arr;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = in.nextInt();
            total += arr[i];
        }

        dfs(0,0);
        System.out.println(answer);
    }

    static void dfs(int L,int sum){
        if(flag) return;
        if(sum>total/2) return;
        if(L == n){
            if((total - sum)== sum) {
                answer = "YES";
                flag = true;
            }
        }
        else{
            dfs(L+1,sum+arr[L]);
            dfs(L+1,sum);
        }
    }
}
