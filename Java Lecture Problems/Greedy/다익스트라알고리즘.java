package Inflearn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 다익스트라알고리즘 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();//정점의 수
        int m = in.nextInt();//간선의 수

        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<m;i++){
            graph.get(in.nextInt()).add(new Edge(in.nextInt(),in.nextInt()));
        }

        int[] dis = new int[n+1];
        Arrays.fill(dis, Integer.MAX_VALUE);

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(1,0));
        dis[1] = 0;
        while(!pq.isEmpty()){
            Edge tmp = pq.poll();
            int now = tmp.node;
            int nowCost = tmp.cost;
            if(nowCost>dis[now]) continue;
            for (Edge ob : graph.get(now)){
                if(dis[ob.node]>nowCost+ob.cost){ //시작노드에서 바로가는 길보다 현재노드 거쳐서 가는 길의 비용이 더 작을 경우
                    dis[ob.node] = nowCost + ob.cost;
                    pq.offer(new Edge(ob.node,nowCost+ob.cost));
                }
            }
        }
        for(int i=2;i<=n;i++){
            if(dis[i]!=Integer.MAX_VALUE) System.out.println(i+" : "+dis[i]);
            else System.out.println(i+" : impossible");
        }
    }

    static class Edge implements Comparable<Edge>{
        @Override
        public int compareTo(Edge o){
            return this.cost - o.cost;
        }
        public Edge(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        int node;
        int cost;
    }
}
