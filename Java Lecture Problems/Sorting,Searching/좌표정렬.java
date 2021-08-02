package Inflearn;

import java.util.*;

public class 좌표정렬 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        ArrayList<Point> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new Point(in.nextInt(),in.nextInt()));
        }

        Collections.sort(list);
        for(Point o : list){
            System.out.print(o.x+" "+o.y+"\n");
        }
    }

    static class Point implements Comparable<Point>{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            //현재 멤버 변수 값이 파라미터로 넘어온 값보다
            //작으면 음수 / 같으면 0 / 크면 양수
            //
            // 메소드 호출하는 this객체
            //this:10 o:20 오름차순으로 오게하려면 this - o
            //this:20 o:10 내림차순 o - this
            if(this.x==o.x){
                return this.y-o.y;
            }
            else{
                return this.x-o.x;
            }
        }
    }
}
