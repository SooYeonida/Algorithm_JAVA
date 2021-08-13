package Inflearn;

public class 이진트리순회_DFS {
    /*
          1
         /\
        2  3
       /\  /\
      4 5 6  7

      전위순회 출력: 1,2,4,5,3,6,7
      중위순회 출력: 4,2,5,1,6,3,7
      후위순회 출력: 4,5,2,6,7,3,1

     */

    Node root;

    public static void main(String[] args) {

    이진트리순회_DFS tree = new 이진트리순회_DFS();
    tree.root = new Node(1);
    tree.root.lt = new Node(2);
    tree.root.rt = new Node(3);
    tree.root.lt.lt = new Node(4);
    tree.root.lt.rt = new Node(5);
    tree.root.rt.lt = new Node(6);
    tree.root.rt.rt = new Node(7);
    tree.DFS(tree.root);

    }

    public void DFS(Node root){
        if(root == null) return;
        else{
//            전위순회
            System.out.print(root.data+" ");
            DFS(root.lt);
            DFS(root.rt);

//            중위순회
//            DFS(root.lt);
//            System.out.print(root.data+" ");
//            DFS(root.rt);

//            후위순회
//            DFS(root.lt);
//            DFS(root.rt);
//            System.out.print(root.data+" ");

        }
    }

     static class Node{
        public Node(int data) {
            this.data = data;
            this.lt= null;
            this.rt = null;
        }

        int data;
        Node lt, rt;
    }
}
