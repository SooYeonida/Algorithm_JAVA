package BOJ;
import java.util.*;
public class 주사위굴리기 {
    static int[] dice = new int[7];
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); //지도 세로
        int m = in.nextInt(); //지도 가로
        int dice_x = in.nextInt();
        int dice_y = in.nextInt(); //주사위 x,y좌표
        int k = in.nextInt(); //명령의 개수

        int[][] map = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                map[i][j] = in.nextInt();
            }
        }

        int[] instruction = new int[k];
        for(int i=0;i<k;i++){
            instruction[i] = in.nextInt();
        }

        //동 서 북 남
        int[] dy = {1,-1,0,0};
        int[] dx = {0,0,-1,1};
        for(int i=0;i<k;i++){
            int dir = instruction[i];
           //System.out.println("dir :"+dir);
            int next_x = dice_x+dx[dir-1];
            int next_y = dice_y+dy[dir-1];
            //System.out.println("next_x :"+next_x+" next_y: "+next_y);

            if(next_x>=0 && next_x<n && next_y>=0 && next_y<m){
                dice_x = next_x;
                dice_y = next_y;
                roll(dir);
                if(map[next_x][next_y]==0){
                    map[next_x][next_y] = dice[1];
                }
                else{
                    dice[1] = map[next_x][next_y];
                    map[next_x][next_y] = 0;
                }
                System.out.println(dice[6]);
            }
        }

    }

    static void roll(int dir){
        int[] copy = dice.clone();
        switch (dir){
            case 1:{
                //동
                dice[4] = copy[1];
                dice[1] = copy[3];
                dice[3] = copy[6];
                dice[6] = copy[4];
                break;
            }
            case 2:{
                //서
                dice[4] = copy[6];
                dice[1] = copy[4];
                dice[3] = copy[1];
                dice[6] = copy[3];
                break;
            }
            case 3:{
                //남
                dice[2] = copy[6];
                dice[1] = copy[2];
                dice[5] = copy[1];
                dice[6] = copy[5];
                break;
            }
            case 4:{
                //북
                dice[2] = copy[1];
                dice[1] = copy[5];
                dice[5] = copy[6];
                dice[6] = copy[2];
                break;
            }
        }
    }
}
