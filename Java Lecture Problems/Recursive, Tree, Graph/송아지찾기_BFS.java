package Inflearn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 송아지찾기_BFS {
    static int[] dir = {1,-1,5};
    static int cow;
    static ArrayList<Integer> markedList = new ArrayList<>();

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int cur = in.nextInt(); //현수 위치
        cow = in.nextInt(); //송아지 위치

        Node root = new Node(cur);
        bfs(root);
    }

static void bfs(Node root){
    int L = 0;
    Queue<Node> queue = new LinkedList<>();
    markedList.add(root.data);
    queue.offer(root);

    while(!queue.isEmpty()){
        int len = queue.size();
        for(int i=0;i<len;i++){
            Node r = queue.poll();
            if(r.data == cow){
                System.out.println(L);
                return;
            }
            for(int j=0;j<3;j++){
                Node n = new Node(r.data+dir[j]);
                if(!markedList.contains(n.data) && n.data>=1 && n.data<=10000) {
                    markedList.add(n.data);
                    queue.offer(n);
                }
            }
        }
        L++;
    }
}


    static class Node{
        public Node(int data) {
            this.data = data;
        }
        int data;
    }
}
