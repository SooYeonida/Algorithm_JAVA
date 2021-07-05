package Inflearn;
import java.util.*;

public class 특정문자뒤집기 {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String str = in.next();
        char[] array = str.toCharArray();

        //아스키코드 65-90 & 97-122
        int lt = 0;
        int rt = str.length()-1;

        while(lt<rt){
            if(!checkString(array[lt])){
                lt++;
            }
            else if(!checkString(array[rt])){
                rt--;
            }
            else{
                char tmp = array[rt];
                array[rt] = array[lt];
                array[lt] = tmp;
                lt++;
                rt--;
                // 교환
            }
        }
        System.out.println(String.valueOf(array));

        return ;
    }

    public static boolean checkString(char c){
        if((c>=65 && c<=90)|| (c>=97 && c<=122)){
            return true;
        }
        return false;
    }
}
