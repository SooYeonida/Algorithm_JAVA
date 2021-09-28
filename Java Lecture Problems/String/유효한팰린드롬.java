package Inflearn;
import java.util.*;

public class 유효한팰린드롬 {

    public static void main(String[] args) {
       Scanner in = new Scanner(System.in);
        char[] arr = in.nextLine().toUpperCase().toCharArray();

        int lt=0,rt=arr.length-1;
        while(lt<rt){
            if(Character.isAlphabetic(arr[lt]) && Character.isAlphabetic(arr[rt])){
                //같은지 체크
                if(arr[lt] != arr[rt]){
                    System.out.println("NO");
                    return;
                }
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
        System.out.println("YES");
    }

}
