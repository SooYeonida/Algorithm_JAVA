package Inflearn;
import java.util.*;

public class 중복문자제거 {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String str = in.next();
        char[] charArray = str.toCharArray();
        ArrayList<Character> checkList = new ArrayList<>();
        String answer = "";

        for(char c : charArray){
            if(!checkList.contains(c)){
                checkList.add(c);
                answer += c;
            }
        }
        System.out.println(answer);

        return ;
    }
}
