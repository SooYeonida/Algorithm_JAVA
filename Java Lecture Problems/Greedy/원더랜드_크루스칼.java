package Inflearn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 원더랜드_크루스칼 {

    static int[] unf;
    static int find(int v){
        if(v==unf[v]) return v;
        else return unf[v]=find(unf[v]);
    }

    static void union(int a,int b){
        int fa = find(a);
        int fb = find(b);
        if(fa!=fb) unf[fa] = fb;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int v = in.nextInt();
        int e = in.nextInt();

        unf = new int[v+1];
        for(int i=1;i<=v;i++){
            unf[i] = i;
        }

        ArrayList<Edge> list = new ArrayList<>();
        int answer = 0;
        for(int i=0;i<e;i++){
            list.add(new Edge(in.nextInt(),in.nextInt(),in.nextInt()));
        }

        Collections.sort(list); //오름차순 정렬

        //간선개수 = 노드 개수 - 1
        for(Edge edge : list){
            if(find(edge.node1)!= find(edge.node2)) {
                union(edge.node1, edge.node2);
                answer += edge.price;
            }
        }

        System.out.println(answer);

    }

    static class Edge implements Comparable<Edge>{
        public Edge(int node1, int node2, int price) {
            this.node1 = node1;
            this.node2 = node2;
            this.price = price;
        }

        int node1;
        int node2;
        int price;

        @Override
        public int compareTo(Edge o) {
            return this.price - o.price; //간선 비용 오름차순 정렬.
        }
    }
}
