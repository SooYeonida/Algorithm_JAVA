package Inflearn;

import javax.swing.*;
import java.util.Scanner;

public class 최대점수구하기_DFS {
    static int n;
    static int m;
    static Problem answer = new Problem(0,0);
    static Problem[] problems;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt(); //문제 개수
        m = in.nextInt(); //제한 시간

        problems = new Problem[n];
        for(int i=0;i<n;i++){
            problems[i] = new Problem(in.nextInt(),in.nextInt());
        }

        dfs(0,0,0);
        System.out.println(answer.score);
    }

    static void dfs(int L, int score, int time){
        if(time<=m && answer.score<=score){
            answer.time = time;
            answer.score = score;
        }
        if(L==n){
            return;
        }
        else{
           dfs(L+1,problems[L].score+score,problems[L].time+time);
           dfs(L+1,score,time);
        }
    }

    static class Problem{
        public Problem(int score, int time) {
            this.score = score;
            this.time = time;
        }
        int score;
        int time;
    }
}
