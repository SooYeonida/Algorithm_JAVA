package Inflearn;

import java.util.*;

public class 공주구하기 {
    public static void main(String[] args) {
       int answer = 0;
       Queue<Integer> queue = new LinkedList<>();

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();

        for(int i=1;i<=n;i++){
            queue.offer(i);
        }

        while(!queue.isEmpty()){
            for(int i=1;i<k;i++){
                queue.offer(queue.poll());
            }
            queue.poll(); //k를 외친 수 없애기

            if(queue.size()==1){
                answer = queue.poll();
            }
        }
        System.out.println(answer);
    }
}
