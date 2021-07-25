package Inflearn;

import java.util.Scanner;
import java.util.Stack;

public class 괄호문자제거 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();

        Stack<Character> stack = new Stack<>();
        for(char c : str.toCharArray()){
            if(c==')'){
                if(!stack.isEmpty()) {
                    while (stack.peek() != '(') {
                        stack.pop();
                    }
                    stack.pop(); //(빼줌
                }
            }
            else{
                stack.push(c);
            }

        }

        if(!stack.isEmpty()){
            for(char c : stack){
                System.out.print(c);
            }
        }
    }
}
