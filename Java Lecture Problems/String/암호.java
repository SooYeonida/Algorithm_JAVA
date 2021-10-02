package Inflearn;

import java.util.Scanner;

public class 암호 {

    public static void main(String[] args) {
         Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        String str = in.next();
        String answer = "";
        for(int i= 0;i<n;i++){
            String pwd = str.substring(7*i,7*i+7);
            String binary = "";
            for(int j=0;j<pwd.length();j++){
                if(pwd.charAt(j)=='#') binary+='1';
                else binary+='0';
            }
            int stringToDecimal = Integer.parseInt(binary,2);
            //2진수 문자열을 10진수로 변환.
            answer += (char)stringToDecimal;
            //Character.toChars(stringToDecimal);도 됨. 
        }
        System.out.println(answer);
    }

}
