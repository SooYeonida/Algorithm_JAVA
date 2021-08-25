package Problem.DFS_BFS;

public class LV2_타겟넘버 {
    static int tg;
    static int[] num;
    static int answer = 0;

    public int solution(int[] numbers, int target) {
        num = numbers;
        tg = target;

        dfs(0,0);

        return answer;
    }

    static void dfs(int L,int sum){
        if(L==num.length){
            if(sum==tg){
                answer++;
            }
        }
        else{
            dfs(L+1,sum+num[L]);
            dfs(L+1,sum-num[L]);
        }
    }
}

