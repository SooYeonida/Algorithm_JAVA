package Inflearn;

import java.util.Scanner;

public class 숫자만추출 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String str = in.next();

        str = str.replaceAll("[^0-9]", "");

        char[] array = str.toCharArray();

        String answer = "";

        int flag = -1;
        for (char c : array) {
            if (c != '0') {
                if(flag==-1) {
                    flag=0;
                }
                answer+=c;
            }
            else{
                if(flag==0){
                    answer += c;
                }
            }
        }
        //flag안쓰고 그냥 string Iteger.parseInt(answer)하면 간단.

        //위와같은식도 정답이지만 좀더 깔끔하게 짜려면

//        int ans =0;
//        for(char c:array){
//            if(c>=48&&c<=57){
//                ans = ans * 10 + (c-48);
//            }
//        }

        System.out.println(answer);

    }
}
