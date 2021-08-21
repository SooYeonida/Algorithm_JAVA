package Inflearn;

import java.util.Scanner;

public class 씨름선수 {
    //그리디 : 현재에서 최선의 선택.

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Person[] list = new Person[n];
        for(int i=0;i<n;i++){
            list[i] = new Person(in.nextInt(),in.nextInt());
        }

        int answer = 0;

        for(int i=0;i<n;i++){
            Person p1 = list[i];
            boolean flag = true;
            for(int j=0;j<n;j++){
                if(i!=j){
                    Person p2 = list[j];
                    if(p1.height <p2.height &&p1.weight<p2.weight){
                        flag = false;
                        break;
                    }
                }
            }
            if(flag) answer++;
        }

        System.out.println(answer);
    }
    static class Person{
        int height;
        int weight;
        public Person(int height, int weight){
            this.height = height;
            this.weight = weight;
        }
    }
}
