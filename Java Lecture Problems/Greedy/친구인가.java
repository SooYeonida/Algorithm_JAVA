package Inflearn;

import java.util.Scanner;

public class 친구인가 {
    static int[] unf;
    static int find(int v){
        if(v==unf[v]) return v;
        else return unf[v]=find(unf[v]);
    } //unf[v] = 함으로써 경로 압축

    static void union(int a, int b){
        int fa = find(a);
        int fb = find(b);
        if(fa!=fb) unf[fa] = fb;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        unf = new int[n+1];
        for(int i=1;i<=n;i++) unf[i] = i;
        //자기자신으로 초기화

        for(int i=1;i<=m;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            union(a,b);
        }

        int a = in.nextInt();
        int b = in.nextInt();
        int fa = find(a);
        int fb = find(b);
        if(fa==fb) System.out.println("YES");
        else System.out.println("NO");
    }
}
