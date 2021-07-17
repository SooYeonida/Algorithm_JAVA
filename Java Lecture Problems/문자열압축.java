package Inflearn;

import java.util.Scanner;

public class 문자열압축 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        str+=" ";
        int appearNum = 1;
        //char[] array = in.next().toCharArray();
        String answer = "";

        for(int i=0;i<str.length()-1;i++){
            if(str.charAt(i)!=str.charAt(i+1)){
                answer += str.charAt(i);
                if(appearNum>1) answer+=String.valueOf(appearNum);
                appearNum = 1;
            }
            else{
                appearNum++;
            }
        }
//        char target = ' ';
//        int appearNum = 0;

//        for (int i = 0; i < array.length; i++) {
//            if (target != array[i]) {
//                if (i != 0) {
//                    answer += target;
//                    if (appearNum > 1) {
//                        answer += appearNum;
//                    }
//                }
//
//                appearNum = 0;
//                target = array[i];
//
//            }
//            appearNum++;
//            if (i == array.length - 1) {
//                answer += target;
//                if (appearNum > 1) {
//                    answer += appearNum;
//                }
//            }
//        }

        System.out.println(answer);
        //이렇게 안해줘도 되고 그냥 처음에 문자열에 비문자 넣어주면 해결.
        //target 지정 필요 없이 s.charAt(i)와 s.charAt(i+1)이랑 비교하면 간단해짐.
    }
}
