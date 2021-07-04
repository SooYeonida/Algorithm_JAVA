package Problem.정렬;

import java.util.Collections;
import java.util.Stack;
import java.util.*;

public class Lv2_가장큰수 {

        static String[] stringArray;
        public String solution(int[] numbers) {
            String answer = "";
            stringArray = new String[numbers.length];

            //문자열 배열로 전환
            for(int i=0;i<numbers.length;i++){
                stringArray[i] = String.valueOf(numbers[i]);
            }

            Arrays.sort(stringArray, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return (o2+o1).compareTo(o1+o2);
                }
            });

            return stringArray[0].equals("0")? stringArray[0]: String.join("",stringArray);
        }

}
