package Inflearn;

import java.util.Scanner;

public class 숫자만추출 {
    public static void main(String[] args) {
 Scanner in = new Scanner(System.in);
        char[] arr = in.next().toCharArray();

        String answer = "";
        for(char c :arr){
            if(Character.isDigit(c)){
                answer += c;
            }
        }

        System.out.println(Integer.valueOf(answer));

    }
}
