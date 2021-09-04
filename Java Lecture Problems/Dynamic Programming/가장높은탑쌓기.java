package Inflearn;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class 가장높은탑쌓기 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        Brick[] arr = new Brick[n];
        Integer[] dy = new Integer[n];
        Arrays.fill(dy,0);

        for(int i=0;i<n;i++){
            arr[i] = new Brick(in.nextInt(),in.nextInt(),in.nextInt());
        }

        Arrays.sort(arr);

        for(int i=0;i<n;i++){
            int maxLength = 0;
            for(int j=i;j>=0;j--){
                if(arr[i].s<arr[j].s && arr[i].w<arr[j].w){
                    //현재 보다 넓이가 넓고 무게가 무거운 경우
                    if(maxLength<=dy[j]){
                        maxLength = dy[j];
                    }
                }
            }
            dy[i] = maxLength + arr[i].h;
        }

        Arrays.sort(dy, Collections.reverseOrder());
        System.out.println(dy[0]);
    }

    static class Brick implements Comparable<Brick>{
        public Brick(int s, int h, int w) {
            this.s = s;
            this.h = h;
            this.w = w;
        }

        int s; //밑면 넓이
        int h; //높이
        int w; //무게

        @Override
        public int compareTo(Brick o) {
            return o.s - this.s;
        }
    }
}
