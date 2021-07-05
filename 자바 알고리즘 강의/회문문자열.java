package Inflearn;

import java.util.*;

public class 회문문자열 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();

        str = str.toUpperCase();
        char[] array = str.toCharArray();

        int lt =0;
        int rt = str.length()-1;

        while(lt<rt){
            if(array[lt] == array[rt]){
                lt++;
                rt--;
            }
            else{
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

}
