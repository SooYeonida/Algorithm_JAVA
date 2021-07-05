package Inflearn;

import java.util.*;

public class 문장속단어 {
        public static void main(String[] args){
            Scanner in=new Scanner(System.in);
            String str = in.nextLine();

            //next랑 nextline 주의!!! 한줄받으려면 nextline

            String[] array = str.split(" ");
            String answer = "";

            for(String s : array){
                if (s.length()>answer.length()){
                    answer = s;
                }
            }
            System.out.println(answer);

            return ;
        }
}
