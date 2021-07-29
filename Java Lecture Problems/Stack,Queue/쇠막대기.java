package Inflearn;

import java.util.Scanner;
import java.util.Stack;

public class 쇠막대기 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();

        int answer = 0;
        Stack<Character> stack = new Stack<>();
//        for(char c : str.toCharArray()){
//            if(c=='('){
//                stack.push(c);
//                System.out.println("stack size ;"+stack.size());
//            }
//            else {
//                //레이저의 )인지
//                //막대기 끝을 알리는 )인지 판단 필요
//                System.out.println("str: "+stack.peek());
//                if(stack.peek()=='('){
//                    stack.pop();
//                    answer += stack.size();
//                    System.out.println("answer; "+answer);
//                }
//                else{
//                    stack.pop();
//                    answer ++;
//                    System.out.println("answer; "+answer);
//                }
//            }
//        }
//        이코드가 안됐던 이유 : 비교할때 stack.peek()으로 비교해서 이전이 )일 경우를 고려해주지 않음.

        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='('){
                stack.push(str.charAt(i));
            }
            else{
                stack.pop();
                if(str.charAt(i-1)=='(') {
                    answer+=stack.size();
                }
                else {
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
}
