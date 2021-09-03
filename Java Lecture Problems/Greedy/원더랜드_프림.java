package Inflearn;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 원더랜드_프림 {
    static int[] unf;
    static int find(int v){
        if(v==unf[v]) return v;
        else return unf[v] = find(unf[v]);
    }
    static void union(int a, int b){
     int fa = find(a);
     int fb = find(b);
     if(fa!=fb) unf[a] = b;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int v = in.nextInt();
        int e = in.nextInt();

        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        for(int i=0;i<=v;i++){
            graph.add(new ArrayList<Edge>());
        }

        int[] ch = new int[v+1];
        for(int i=0;i<e;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            graph.get(a).add(new Edge(b,c)); //a에서 b로 가는 간선의 비용이 c
            graph.get(b).add(new Edge(a,c)); //b에서 a로 가는 간선의 비용이 c
        }

        int answer = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(1,0));
        while(!pq.isEmpty()){
            Edge tmp = pq.poll();
            int ev = tmp.node; //도착 정점
            if(ch[ev] == 0){
                ch[ev] = 1;
                answer += tmp.cost;
                for(Edge ob : graph.get(ev)){ //
                    if(ch[ob.node]==0) pq.offer(new Edge(ob.node,ob.cost));
                }
            }
        }

        System.out.println(answer);

    }
    static class Edge implements Comparable<Edge> {
        @Override
        public int compareTo(Edge o){
            return this.cost -o.cost;
        }

        public Edge(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        int node;
        int cost;
    }
}
