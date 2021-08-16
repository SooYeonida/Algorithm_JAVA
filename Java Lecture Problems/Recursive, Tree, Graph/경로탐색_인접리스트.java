package Inflearn;

import java.util.ArrayList;
import java.util.Scanner;

public class 경로탐색_인접리스트 {
    /*
    경로탐색 인접행렬과 문제 동일

    n이 큰 경우에는 인접행렬은 for문을 돌기때문에 비효율적. 메모리 소모 큼.
     */

    static int n,m,answer = 0;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] check;

    static void dfs(int v){
        if(v==n) answer++;
        else{
            for(int nv : graph.get(v)){
                if(check[nv] == 0){
                    check[nv] = 1;
                    dfs(nv);
                    check[nv] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();

        graph = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<Integer>());
        }
        check = new int[n+1];

        for(int i =0;i<m;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            graph.get(a).add(b);
        }

        check[1] = 1;
        dfs(1);
        System.out.println(answer);

    }
}
