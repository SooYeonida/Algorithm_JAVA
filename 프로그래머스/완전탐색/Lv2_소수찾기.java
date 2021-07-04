package Problem.완전탐색;

import java.util.*;

public class Lv2_소수찾기 {

        static ArrayList<Integer> combination = new ArrayList<>();

        public int solution(String numbers) {
            String[] numberSplit = numbers.split("");

            for(int i=1;i<=numberSplit.length;i++){
                permutation(numberSplit,0,numberSplit.length,i);
            }

            int answer = findPrime();

            //만들수있는 소수 개수
            return answer;
        }

        private int findPrime() {
            int answer = 0;
            for(int i=0;i<combination.size();i++){
                int num = combination.get(i);
                if(Math.pow((int)Math.sqrt(num), 2) != num){
                    boolean prime_check = false;
                    for(int j=2;j<num;j++){
                        if(num%j==0){
                            prime_check = true;
                            break;
                        }
                    }
                    if(!prime_check){
                        answer++;
                    }
                }
                else{
                    if(num ==2){
                        answer++;
                    }
                }
            }
            return answer;
        }

        static void permutation(String[] arr, int depth, int n, int r) {
            if (depth == r) {
                String num = "";
                for(int i=0;i<r;i++){
                    num += arr[i];
                }
                if(!combination.contains(Integer.parseInt(num))){
                    combination.add(Integer.parseInt(num));
                }
                return;
            }

            for (int i=depth; i<n; i++) {
                swap(arr, depth, i);
                permutation(arr, depth + 1, n, r);
                swap(arr, depth, i);
            }
        }

        static void swap(String[] arr, int depth, int i) {
            String temp = arr[depth];
            arr[depth] = arr[i];
            arr[i] = temp;
        }
}
