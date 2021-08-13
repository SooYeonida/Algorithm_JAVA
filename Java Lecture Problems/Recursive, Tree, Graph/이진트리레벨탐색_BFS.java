package Inflearn;

import java.util.LinkedList;
import java.util.Queue;

public class 이진트리레벨탐색_BFS {
    /*
         1
        /\
       2  3
      /\  /\
     4 5 6  7
     레벨 탐색 순회 출력: 1 2 3 4 5 6 7
    */

    public static void main(String[] args) {
        Node root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);
        root.rt.lt = new Node(6);
        root.rt.rt = new Node(7);

        BFS(root);
    }

    static void BFS(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int L = 0;
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(current.data + " ");
            if (current.lt != null) {
                queue.offer(current.lt);
            }
            if (current.rt != null) {
                queue.offer(current.rt);
            }
        }//레벨끝
        L++;
        System.out.println();
    }


    static class Node {
        public Node(int data) {
            this.data = data;
            this.lt = null;
            this.rt = null;
        }

        int data;
        Node lt, rt;

    }
}

