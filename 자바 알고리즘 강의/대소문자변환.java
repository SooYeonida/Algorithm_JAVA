package Inflearn;
import java.util.Scanner;

public class 대소문자변환 {

        public static void main(String[] args){
            Scanner in=new Scanner(System.in);
            String str = in.next();

            String answer = "";

            for(char x : str.toCharArray()){
                if(Character.isUpperCase(x)){
                    answer += Character.toLowerCase(x);
                }
                else{
                    answer += Character.toUpperCase(x);
                }
            }
            System.out.println(answer);
            return ;
        }
}
