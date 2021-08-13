package Inflearn;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class test_binarytree_bfs {
    /*
         1
        /\
       2  3
      /\  /\
     4 5 6  7
     이진트리 구현
     dfs : 1 2 4 5 3 6 7
     bfs : 1 2 3 4 5 6 7

    */

    public static void main(String[] args) {
        Node root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);
        root.rt.lt = new Node(6);
        root.rt.rt = new Node(7);

        bfs(root);
    }

    static void dfs(Node root){
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node r = stack.pop();
            System.out.print(r.data+" ");
            if(r.rt!=null)
                stack.push(r.rt);
            if(r.lt!=null)
                stack.push(r.lt);
        }
    }

    static void bfs(Node root){
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            Node r = queue.poll();
            System.out.print(r.data+" ");
            if(r.lt!=null)
                queue.offer(r.lt);
            if(r.rt!=null){
                queue.offer(r.rt);
            }
        }

    }

    static class Node{
        public Node(int data) {
            this.data = data;
            this.lt = null;
            this.rt = null;
        }

        int data;
        Node lt,rt;

    }
}
