package Inflearn;

import java.util.*;

public class K번째큰수 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();//총 카드수
        int k = in.nextInt();//3장을 뽑아 더한 합의 경우의 수중 k번째 큰 수를 찾아야함.

        Integer[] array =  new Integer[n];
        for(int i=0;i<n;i++){
            array[i] = in.nextInt();
        }
        Arrays.sort(array, Collections.reverseOrder());

        HashMap<Integer,Integer> hashMap = new HashMap<>();
        int sum = 0;
        for(int i = 0;i<2;i++){
            sum += array[i];
        }
        //2개 먼저 합 구함

        ArrayList<Integer> arrayList = new ArrayList<>();
        int lt=0;
        for(int rt=2;rt<n;rt++){
            //lt로 sum 윈도우 옮겨야함 하나 빼고 하나 더하고
            for(int i=rt;i<n;i++){
                //rt부터 하나씩 더한값 hash넣기.
                sum += array[i];
                arrayList.add(sum);
                sum -= array[i];
            }
            sum -= array[lt++];
            sum += array[rt];
        }

        //arraylist에 다넣고 hash로 중복 거르기
        Collections.sort(arrayList,Collections.reverseOrder());
        int cnt =1;
        for(Integer a : arrayList){
            if(!hashMap.containsValue(a)){
                hashMap.put(cnt++,a);
            }
        }

        System.out.println(hashMap.getOrDefault(k,-1));
    }
}
