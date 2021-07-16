package Inflearn;

import java.util.Scanner;

public class 암호 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        String code = in.next();
        String decode = "";
        String answer = "";

        for(int i=0;i<num;i++){
            for(int j=i*7;j<7*i+7;j++){
                if(code.charAt(j) == '#'){
                    decode += 1;
                }
                else{
                    decode += 0;
                }
            }
            int n =Integer.parseInt(decode,2); //2진수를 10진수로 변환
            decode = "";
            answer += String.valueOf(Character.toChars(n));
        }

        System.out.println(answer);
        //Integer.parseInt에서 NumberFormatException -> 문자열을 숫자데이터 유형으로 변환하려고 할때 발생

    //간단한 답
//        for(int i = 0;i<num;i++){
//            String tmp = code.substring(0,7).replace('#','1').replace('*','0');
//            int number = Integer.parseInt(tmp,2);
//            answer += (char)number;
//            code = code.substring(7);
//        }
    }


}
