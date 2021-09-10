package BOJ;

import java.util.LinkedList;
import java.util.Scanner;

public class 컨테이어벨트위의로봇 {
    static int n;
    static int k;
    static LinkedList<Integer> index = new LinkedList<>(); //돌아가는 위치를 저장하기 위한 리스트
    static int[] belt; // 내구도 저장 리스트
    static int[] robot; //로봇 저장 리스트

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt(); //컨테이너 벨트 길이
        k = in.nextInt(); //내구도가 0인 칸의 개수 제한

        belt = new int[n*2];
        robot = new int[n*2];

        for (int i = 0; i < n * 2; i++) {
            belt[i] = in.nextInt();
            index.add(i);
        }

        int time = 1;
        int cnt = 0;

        while (true) {
            //1: 로봇과 함께 한 칸 회전
            int tmp = index.get(index.size()-1);
            index.remove(index.size()-1);
            index.add(0,tmp);

            int up = index.get(0);
            int down = index.get(n-1);

            //내릴 로봇 내리기
            if(robot[down]==1) robot[down] = 0;

            //2: 로봇 이동
            //index.size()-2가 아닌 n-1하는 이유 : 어차피 로봇은 0~ n-1까지에만 존재하니까
            for (int i = n-1; i >=0; i--) {
                int idx = index.get(i);
                int next = index.get(i+1);
                //i, i+1이 아닌 index.get(i) , index.get(i+1)
                if(robot[idx]==1 && belt[next]>0 && robot[next]==0){
                    belt[next]--;
                    robot[next] = 1;
                    robot[idx] = 0;
                    if(belt[next]==0) cnt++;
                }
            }

            //내릴 로봇 내리기
            if(robot[down]==1) robot[down] = 0;

            //로봇 올리기
            if(belt[up]>0 && robot[up]==0){
                robot[up] = 1; //0이 아니라 up위치에서
                belt[up]--; //0이 아님
                if(belt[up]==0) cnt++;
            }

            if(cnt>=k) break;
            time++;
        }

        System.out.println(time);

    }

}
