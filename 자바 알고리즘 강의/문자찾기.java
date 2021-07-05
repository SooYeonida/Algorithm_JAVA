package Inflearn;

import java.util.Scanner;

public class 문자찾기 {

        public static void main(String[] args){
            Scanner in = new Scanner(System.in);
            String str = in.next(); //문자열
            char c = in.next().charAt(0); //찾는 문자

            str = str.toUpperCase();
            c = Character.toUpperCase(c);

            int answer = 0;

            for (int i=0;i<str.length();i++){
                if(str.charAt(i) == c){
                    answer++;
                }
            }

//            for(char x : str.toCharArray()){
//                이렇게 for each 문으로 해도 됨.
//            }

            System.out.println(answer);

            return ;
        }
}
