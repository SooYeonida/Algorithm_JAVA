package Problem.완전탐색;
import java.util.*;
public class LV2_소수찾기_sol2 {
    static int answer = 0;
    static int[] check;
    static ArrayList<Integer> list = new ArrayList<>();
    static int[] num;

    public int solution(String numbers) {

        num = new int[numbers.length()];
        check = new int[numbers.length()];
        for(int i=0;i<numbers.length();i++){
            num[i] = Character.getNumericValue(numbers.charAt(i));
        }

        dfs("0");

        return answer;
    }

    static void dfs(String s){

        int n = Integer.parseInt(s);

        boolean ncheck = true;
        for(int i=2;i<n;i++){
            if(n>1 && n!=i && n%i==0){
                ncheck = false;
                break;
            }
        }
        if(n> 1 && ncheck && !list.contains(n)) {
            answer++;
            list.add(n);
        }

        for(int i=0;i<num.length;i++){
            if(check[i]==0){
                String before = s;
                check[i] = 1;
                dfs(s+=String.valueOf(num[i]));
                check[i] = 0;
                s = before;
            }
        }
    }
}
