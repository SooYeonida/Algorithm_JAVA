package Inflearn;

import java.util.LinkedList;
import java.util.Stack;

public class test_tree_dfs {
     /*
         1
        /\ \
       2  3  4
      /\  /\\
     5 6 7 8 9
     일반 트리 구현

    */

    public static void main(String[] args) {
        Node[] nodes = new Node[11];
        for(int i=1;i<=10;i++){
            nodes[i] = new Node(i);
        }
        addEdge(nodes[1],nodes[2]);
        addEdge(nodes[1],nodes[3]);
        addEdge(nodes[1],nodes[4]);
        addEdge(nodes[2],nodes[5]);
        addEdge(nodes[2],nodes[6]);
        addEdge(nodes[3],nodes[7]);
        addEdge(nodes[3],nodes[8]);
        addEdge(nodes[3],nodes[9]);

        dfs(nodes[1]);
    }

    static void dfs(Node root){
        Stack<Node> stack = new Stack<>();

        root.marked = true;
        stack.push(root);

        while(!stack.isEmpty()){
            Node r = stack.pop();
            System.out.print(r.data+" ");

            for(Node n : r.adjacent){
                if(n.marked!=true){
                    n.marked = true;
                    stack.push(n);
                }
            }
        }
    }

    static void addEdge(Node a,Node b){
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
