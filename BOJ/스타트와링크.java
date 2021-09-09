package BOJ;

import java.util.Scanner;

public class 스타트와링크 {
    /*n은 짝수
    n/2로 스타트팀, 링크팀
    1-n
    sij : i번 사람과 j번 사람이 같은 팀에 속했을때 더해지는 능력
    팀의 능력치 : 팀에 속한 모든 쌍의 능력치 sij의 합
    sij != sji
    i번 사람과 j번 사람이 같은 팀에 속했을 때, 팀에 더해지는 능력치는 Sij
    */

    static int n;
    static int[][] s;
    static int[] combi;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt(); //n은 짝수
        s = new int[n + 1][n + 1];
        combi = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                s[i][j] = in.nextInt();
            }
        }

        dfs(0, 1);
        System.out.println(min);
    }

    //조합 구해서 능력치 차이 구하기.
    static void dfs(int L, int start) {
        if (L == n/2) {
            //조합 완성
            calculate();
        } else {
            for (int i = start; i < n; i++) {
                    combi[i-1] = 1;
                    dfs(L + 1, i + 1);
                    combi[i-1] = 0;
            }
        }
    }

    static int min = Integer.MAX_VALUE;
    static void calculate(){
        int team_start = 0;
        int team_link = 0;

        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                if(combi[i]==1 && combi[j]==1){
                    team_start += (s[i][j] + s[j][i]);
                }
                if(combi[i]==0 && combi[j]==0){
                    team_link += (s[i][j] + s[j][i]);
                }
            }
        }
        //둘다 범위를 n까지 해버리면 같은 숫자에 대해서 더하는 상황 발생

        int dif = Math.abs(team_start - team_link);

        if(dif==0){
            System.out.println(dif);
            System.exit(0);
        }

        min = Math.min(min,dif);
    }
}
