package Inflearn;
import java.util.*;

public class 유효한팰린드롬 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();

        str = str.toUpperCase();
        char[] baseArray = str.toCharArray();
        char[] compareArray = new StringBuilder(str).reverse().toString().toCharArray();

        String base = "";
        String compare = "";

        for(int i=0;i<baseArray.length;i++){
            if(Character.isAlphabetic(baseArray[i])){
                base += baseArray[i];
            }
            if(Character.isAlphabetic(compareArray[i])){
                compare += compareArray[i];
            }
        }

        if(base.equals(compare)){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }
    }

}
