package Inflearn;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 응급실 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        Queue<Person> queue = new LinkedList();
        for(int i=0;i<n;i++){
            int danger = in.nextInt();
            queue.offer(new Person(i,danger));
        }

        int answer = 1;
        while(!queue.isEmpty()){
           Person tmp = queue.poll();
           for(Person x : queue){ //queue도 굳이 하나씩 뽑아서가 아니라 반복문으로 얻을 수 있음
               if(x.danger>tmp.danger){
                   queue.offer(tmp);
                   tmp = null;
                   break;
               }
           }
           if(tmp!=null){
               if(tmp.id==m){
                   System.out.println(answer);
                   break;
               }
               else{
                   answer++;
               }
           }
        }

    }

    static class Person{

        int id = 0;
        int danger = 0;

        public Person(int index, int danger) {
            this.id = index;
            this.danger = danger;
        }
    }
}
