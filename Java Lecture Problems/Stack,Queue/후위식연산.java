package Inflearn;

import java.util.Scanner;
import java.util.Stack;

public class 후위식연산 {
    public static void main(String[] args) {
        //피연산자 만나면 stack
        //연산자 만난면 2개빼서 계산후 다시 stack

        Scanner in = new Scanner(System.in);
        String str = in.next();

        int cal = 0;

        Stack<Integer> stack = new Stack<>();
        for(char c : str.toCharArray()){
            if(Character.isDigit(c)){
                stack.push(Character.getNumericValue(c));
            }
            else{
                if(!stack.isEmpty()){
                    int v2 = stack.pop();
                    int v1 = stack.pop(); //53-일때 앞의 숫자에서 뒤에껄 빼는걸 명시
                    if(c=='+'){
                        cal = v1 + v2;
                    }
                    else if(c=='-'){
                        cal = v1 - v2;
                    }
                    else if(c=='%'){
                        cal = v1 % v2;
                    }
                    else if(c=='/'){
                        cal = v1 / v2;
                    }
                    else if(c=='*'){
                        cal = v1 * v2;
                    }
                    stack.push(cal);
                }
            }
        }

        System.out.println(stack.pop());
    }
}
