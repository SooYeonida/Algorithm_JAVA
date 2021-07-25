package Inflearn;

import java.util.Scanner;
import java.util.Stack;

public class 올바른괄호 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();

//Tip! 괄호가 나오면 거의 stack으로 풀면 됨
//        int left = 0,right=0;
//        for(char c : str.toCharArray()){
//            if(c=='(') left++;
//            if(c==')') right++;
//        }
//        if(left==right){
//            System.out.println("YES");
//        }
//        else{
//            System.out.println("NO");
//        }
//        위 코드는 (()))( 이렇게 되어있을 경우에도 개수로만 판단해서 yes라고함

        Stack<Character> stack = new Stack<>();
        boolean answer = true;
        for(char c : str.toCharArray()){
            if(c == '('){
                stack.push(c);
            }
            else if(c == ')'){
                if(!stack.isEmpty()){
                    stack.pop();
                }
                else{
                    answer = false;
                    break;
                }
            }
        }
        if(answer) {
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }


    }
}
