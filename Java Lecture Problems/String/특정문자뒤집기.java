package Inflearn;
import java.util.*;

public class 특정문자뒤집기 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] arr = in.next().toCharArray();
        int lt = 0,rt = arr.length-1;
        while(lt<rt){
            if(Character.isAlphabetic(arr[lt]) && Character.isAlphabetic(arr[rt])){
                char tmp = arr[lt];
                arr[lt] = arr[rt];
                arr[rt] = tmp;
                lt++;
                rt--;
            }
            else if(!Character.isAlphabetic(arr[lt])){
                lt++;
            }
            else{
                rt--;
            }
        }

        System.out.println(String.valueOf(arr));
    }
}
