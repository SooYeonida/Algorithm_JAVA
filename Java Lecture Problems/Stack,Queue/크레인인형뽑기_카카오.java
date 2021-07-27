package Inflearn;

import java.util.Scanner;
import java.util.Stack;

public class 크레인인형뽑기_카카오 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int answer = 0;

        int n = in.nextInt();
        int[][] board = new int[n][n];
        int[] height = new int[n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j] = in.nextInt();
            }
        }

        int m = in.nextInt();
        int[] moves = new int[m];
        for(int i=0;i<m;i++){
            moves[i] = in.nextInt();
        }
        //moves위치는 1부터 시작함

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(board[j][i]!=0){//각 열마다 인형 쌓인 높이가 어떻게 되는지
                    height[i] = j;
                    break;
                }
            }
        }

        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<moves.length;i++){
            int crain_position = moves[i]-1;
            if(height[crain_position] < n) {
                int crain_peek = board[height[crain_position]][crain_position];
                board[height[crain_position]][crain_position] = 0;
                height[crain_position] = height[crain_position] + 1;
                if(!stack.isEmpty()){
                    if(stack.peek()== crain_peek){
                        answer++;
                        stack.pop();
                    }
                    else{
                        stack.push(crain_peek);
                    }
                }
                else{
                    stack.push(crain_peek);
                }
            }
        }

        System.out.println(answer*2);
    }
}
