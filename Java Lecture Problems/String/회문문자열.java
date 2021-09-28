package Inflearn;

import java.util.*;

public class 회문문자열 {
    public static void main(String[] args) {
       Scanner in = new Scanner(System.in);
        String str = in.next().toUpperCase();

        String reverse = new StringBuilder(str).reverse().toString();

        if(reverse.equals(str)){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }
    }

}
