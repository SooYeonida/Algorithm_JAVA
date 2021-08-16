package Inflearn;

import java.util.LinkedList;
import java.util.Queue;

public class Tree_말단노드까지가장짧은경로 {
    /*
       1
       /\
      2  3
     /\
    4  5
    그림과 같은 이진트리에서 루트 노드 1에서 말단노드까지의 길이 중 가장 짧은 길이를 구하는 프로그램 작성
    경로의 길이: 루트노드에서 말단노드까지 가는데에 간선 개수

    가장 짧은 길이: 3번 노드까지의 1

    최단거리 문제는 bfs
     */

    public static void main(String[] args) {
        Node[] nodes = new Node[6];
        for(int i=1;i<nodes.length;i++){
            nodes[i] = new Node(i);
        }

        addEdge(nodes[1],nodes[2]);
        addEdge(nodes[1],nodes[3]);
        addEdge(nodes[2],nodes[4]);
        addEdge(nodes[2],nodes[5]);

        bfs(nodes[1]);
    }

    static void bfs(Node root){
        Queue<Node> queue = new LinkedList<>();
        root.marked = true;
        queue.offer(root);

        int L = 0;

        while(!queue.isEmpty()){
            int len = queue.size();
            for(int i=0;i<len;i++){
                Node n = queue.poll();
                if(n.adjacent.size() == 1){
                    //말단노드
                    System.out.println(L);
                    return;
                }
                else {
                    for (Node c : n.adjacent) {
                        if(c.marked!=true) {
                            c.marked = true;
                            queue.offer(c);
                        }
                    }
                }
            }
            //레벨끝
            L++;
        }
    }

    static void addEdge(Node a, Node b){
        if(!a.adjacent.contains(b)) a.adjacent.add(b);
        if(!b.adjacent.contains(a)) b.adjacent.add(a);
    }

    static class Node{
        public Node(int data) {
            this.data = data;
            this.adjacent = new LinkedList<>();
            this.marked = false;
        }

        int data;
        LinkedList<Node> adjacent;
        boolean marked;

    }

}
