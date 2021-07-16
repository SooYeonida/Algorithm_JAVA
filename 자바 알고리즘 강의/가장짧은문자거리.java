package Inflearn;

import java.util.Scanner;

public class 가장짧은문자거리 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String str = in.next();
        char c = in.next().charAt(0);
        int pos = 1000;//1부터 잡아주면 찾는 문자가 멀리있을 경우 1234 이런식으로 거리계산됨.
        int[] answer = new int[str.length()];

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == c) {
                pos = 0;
                answer[i] = 0;
            } else {
                pos++;
                answer[i] = pos;
            }
        }

        pos = 1000;
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == c) {
                pos = 0;
            } else {
                pos++;
                answer[i] = Math.min(answer[i],pos);
            }
        }

        for(int n : answer){
            System.out.printf("%d ",n);
        }

    }
}
