package Inflearn;
import java.util.*;

public class 단어뒤집기 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();

        ArrayList<String> arrayList = new ArrayList<>();

        for(int i=0;i<count;i++){
            String str = in.next();
            arrayList.add(str);
        }

        for(String str : arrayList){
            String answer = "";
//            for(int i = str.length()-1; i>=0;i--){
//                answer+=str.charAt(i);
//            } 이렇게 할 필요 없이
            answer += new StringBuilder(str).reverse().toString();
            System.out.println(answer);
        }

        return ;
    }
}
