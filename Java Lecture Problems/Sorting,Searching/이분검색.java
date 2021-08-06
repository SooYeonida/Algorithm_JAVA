package Inflearn;

import java.util.*;

public class 이분검색 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); //숫자 개수
        int m = in.nextInt(); //찾을 숫자

//        ArrayList<Integer> list = new ArrayList<>();
//        for(int i=0;i<n;i++){
//            list.add(in.nextInt());
//        }
//        Collections.sort(list);
//
//        //12 23 32 57 65 81 87 99
//
//        System.out.println(list.indexOf(m)+1);
// arraylist로 단순 구현        
        

        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = in.nextInt();
        }

        Arrays.sort(arr);
        
        int lt = 0, rt = n-1;
        int answer = -1;
        while(lt<=rt){
            int mid = (lt+rt)/2;
            if(arr[mid]==m){
                answer = mid+1;
                break;
            }
            if(arr[mid]>m) rt= mid-1;
            else lt = mid+1;
        }

        System.out.println(answer);
        
        //이분 검색 구현
    }
}
