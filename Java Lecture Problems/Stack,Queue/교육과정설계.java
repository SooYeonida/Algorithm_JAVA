package Inflearn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 교육과정설계 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String must = in.next();
        String plan = in.next();

    
        Queue<Character> queue = new LinkedList<>();
        for (char c : plan.toCharArray()) {
            queue.add(c);
        }

        boolean answer = false;
        int index = 0;
        while (!queue.isEmpty() && index < must.length()) {
            if (queue.poll() == must.charAt(index)) {
                index++;
                answer = true;
            }
        }

        if(answer) {
            if (index != must.length()) {
                System.out.println("NO");
            }
            else if(index == must.length()){
                System.out.println("YES");
            }
        }
        else{
            System.out.println("NO");
        }
    }
}
