package Inflearn;

import java.util.LinkedList;
import java.util.Queue;

public class BFS연습 {
    /*Graph Search
    BFS : Breadth-First-Search 넓이 우선 검색
    시작점에서 자식노드들을 먼저 다 방문 후 그 다음에 자식의 자식을 방문하는 식. level단위 검

    Queue 이용 ->  queue에서 노드 하나 꺼내고 해당 노드의 자식노드는 전부 queue에 넣음.
    한번 queue에 넣은 노드는 다시 넣지 않음.
    */
    public static void main(String[] args) {
        Graph g = new Graph(9);
        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(1,3);
        g.addEdge(2,4);
        g.addEdge(2,3);
        g.addEdge(3,4);
        g.addEdge(3,5);
        g.addEdge(5,6);
        g.addEdge(5,7);
        g.addEdge(6,8);
        g.bfs();

    }

}

class Graph{
    class Node{
        int data;
        LinkedList<Node> adjacent; //인접한 노드를 linked list에 나열
        boolean marked;

        Node(int data){
            this.data = data;
            this.marked = false;
            adjacent = new LinkedList<Node>();
        }
    }

    Node[] nodes;
    Graph(int size){
        nodes = new Node[size];
        for(int i=0;i<size;i++){
            nodes[i] = new Node(i);
        }
    }

    void addEdge(int i1,int i2){
        Node n1 = nodes[i1];
        Node n2 = nodes[i2];
        if(!n1.adjacent.contains(n2)){
            n1.adjacent.add(n2);
        }
        if(!n2.adjacent.contains(n1)){
            n2.adjacent.add(n1);
        }
    }

    void bfs(){
        bfs(0);
    }

    void bfs(int index){
        Node root = nodes[index];
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        root.marked = true;
        while(!queue.isEmpty()){
            Node r = queue.poll();
            for(Node n : r.adjacent){
                if(n.marked == false){
                    n.marked = true;
                    queue.offer(n);
                }
            }
            System.out.print(r.data+" ");
        }
    }
}
