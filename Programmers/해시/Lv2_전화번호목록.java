package Problem.해시;
import java.util.*;

public class Lv2_전화번호목록 {

        public boolean solution(String[] phone_book) {
            HashMap<Integer,String> hash = new HashMap();

            for(int i=0;i<phone_book.length;i++){
                hash.put(i,phone_book[i]);
            }

            for(int i=0;i<phone_book.length;i++){
                for(Object key : hash.keySet()){

                    if((int)key != i &&  hash.get(key).contains(phone_book[i])){

                        char[] tmp = new char[phone_book[i].length()];
                        hash.get(key).getChars(0,phone_book[i].length(),tmp,0);
                        if(phone_book[i].compareTo(String.valueOf(tmp))==0){
                            return false;
                        }
                    }
                }
            }

            return true;
        }
}
