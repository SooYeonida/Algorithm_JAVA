package Programmers;

import java.util.*;
public class week5_모음사전 {

    static String p = "";
    static char[] w = {'A', 'E', 'I', 'O', 'U'};
    static ArrayList<String> list = new ArrayList<>();

    public int solution(String word) {
        permutation(0);
        Collections.sort(list);

        int answer = list.indexOf(word) + 1;
        return answer;
    }

    static void permutation(int L) {
        if (L == w.length) {
            return;
        }
        for (int i = 0; i < w.length; i++) {
            p += w[i];
            list.add(p);
            permutation(L + 1);
            p = p.substring(0, L);
        }
    }
}
