package Inflearn;

import java.util.Scanner;

public class 가장짧은문자거리 {
    public static void main(String[] args) {

      Scanner in = new Scanner(System.in);

        String str = in.next();
        char c = in.next().charAt(0);
        int[] answer = new int[str.length()];

        int index = str.indexOf(c);
        for (int i = 0; i < str.length(); i++) {
            if(Math.abs(index - i) > Math.abs(str.indexOf(c,i)-i)){
                index = str.indexOf(c,i);
            }
            answer[i] = Math.abs(i - index);
        }

        for(int a : answer){
            System.out.print(a+" ");
        }

    }
}
