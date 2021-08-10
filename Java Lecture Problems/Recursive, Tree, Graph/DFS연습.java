package Inflearn;

import java.util.LinkedList;
import java.util.Stack;

public class DFS연습 {
    /*Graph Search
    BFS : Depth-First-Search 깊이 우선 검색

    inorder
    preorder
    postorder 방법이 속함

    Stack,Linked List 이용 -> stack에서 노드 하나 꺼내고 해당의 노드 자식 노드는 전부 stack에 넣음.
    한번 넣었던 노드는 다시 넣지 않음.

    재귀로도 풀 수 있음. 자식을 stack에 넣지 않고 재귀 호출.
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
        g.dfs();
    }

    static class Graph{
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

        void dfs(){
            dfs(0);
        }

        void dfs(int index){
            Node root = nodes[index];
            Stack<Node> stack = new Stack<>();
            stack.push(root);
            root.marked = true;
            while(!stack.isEmpty()){
                Node r = stack.pop();
                for(Node n : r.adjacent){
                    if(n.marked == false){
                        n.marked = true;
                        stack.push(n);
                    }
                }
                System.out.print(r.data+" ");
            }
        }
    }

}
