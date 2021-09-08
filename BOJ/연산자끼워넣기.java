package BOJ;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 연산자끼워넣기 {
    static int[] check;
    static int n; //숫자 개수
    static int[] arr; //숫자 배열
    static ArrayList<Character> oplist = new ArrayList<>(); //연산자 담는 리스트
    static ArrayList<Integer> result = new ArrayList<>(); //연산 결과 담는 리스트

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt(); //수 개수

        arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = in.nextInt();
        }

         // 덧셈개수 ,뺄셈개수, 곱셈개수, 나눗셈개수 : 합 n-1
        for(int i=0;i<4;i++){
            int o = in.nextInt();
            Character c = null;
            switch (i){
                case 0 : c = '+'; break;
                case 1 : c = '-'; break;
                case 2 : c = '*'; break;
                case 3 : c = '/'; break;
            }
            for(int j=0;j<o;j++){
                oplist.add(c);
            }
        }
        check = new int[oplist.size()];

        dfs(arr[0],1); //연산자 조합 만들기

        System.out.println(Collections.max(result));
        System.out.println(Collections.min(result));
    }

    static void dfs(int num, int L){
        if(L==oplist.size()+1){//연산자에 대한 조합 완성
           result.add(num);
        }
        else{
            for(int i=0;i<oplist.size();i++){
                if(check[i]==0){
                    check[i] = 1;
                    switch (oplist.get(i)){
                        case '+' : dfs(num + arr[L],L+1); break;
                        case '-' : dfs(num - arr[L],L+1); break;
                        case '*' : dfs(num * arr[L],L+1); break;
                        case '/' : dfs(num / arr[L],L+1); break;
                    }
                    check[i] = 0;
                }
            }
        }
    }
}
