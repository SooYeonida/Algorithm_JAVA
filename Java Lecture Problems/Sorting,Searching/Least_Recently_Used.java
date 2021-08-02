package Inflearn;

import java.util.ArrayList;
import java.util.Scanner;

public class Least_Recently_Used {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int s = in.nextInt(); //캐시 크기
        int n = in.nextInt(); //작업 개수

        int[] plan = new int[n];
        for(int i = 0;i<n;i++){
            plan[i] = in.nextInt();
        }

        ArrayList<Integer> list = new ArrayList<>();
        for(int i =0;i<plan.length;i++){
            if(!list.contains(plan[i])){
                if(list.size()<s) {
                    list.add(0, plan[i]);
                }
                else{
                    list.remove(list.size()-1);
                    list.add(0,plan[i]);
                }
            }
            else{
                int index = list.indexOf(plan[i]);
                list.remove(index);
                list.add(0,plan[i]);
                //에러난 이유 : list.remove(plan[i]) 으로 해줬는데 채점사이트 상에서는 list.remove(int index)함수로 알아들어서
                //방지 위해 indexof로 index찾고 해당 index삭제해주는 방식으로 대체
            }
        }

        for(int a: list){
            System.out.print(a+" ");
        }
    }
}
