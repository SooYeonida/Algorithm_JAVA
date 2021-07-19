package Inflearn;

import java.util.HashMap;
import java.util.Scanner;

public class 아나그램 {
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);

        char[] first = in.next().toCharArray();
        char[] second = in.next().toCharArray();

        HashMap<Character,Integer> firstMap = new HashMap<>();
        HashMap<Character,Integer> secondMap = new HashMap<>();

        for(char c : first){
            firstMap.put(c,firstMap.getOrDefault(c,0)+1);
        }

        for(char c : second){
            secondMap.put(c,secondMap.getOrDefault(c,0)+1);
        }

        if(firstMap.size()!=secondMap.size()){
            System.out.println("NO");
        }
        else{
            boolean check = true;
            for(char c : firstMap.keySet()){
                if(secondMap.containsKey(c)){
                    if(firstMap.get(c) != secondMap.get(c)){
                        check = false;
                        break;
                    }
                }
                else{
                    check = false;
                    break;
                }
            }
            if(check){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
        }
    }
}
