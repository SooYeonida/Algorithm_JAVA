package Programmers;

import java.util.*;
public class week2_상호평가 {
    public String solution(int[][] scores) {
        String answer = "";

        ArrayList<Double> grade = new ArrayList<>();
        for(int i=0;i<scores.length;i++){
            ArrayList<Integer> list = new ArrayList<>();
            HashMap<Integer,Integer> map = new HashMap<>();
            int self = 0;

            for(int j=0;j<scores.length;j++){
                if(i==j) self = scores[j][i];
                list.add(scores[j][i]);
                map.put(scores[j][i],map.getOrDefault(scores[j][i],0)+1);
            }

            Collections.sort(list,Collections.reverseOrder());
            Double average = 0.0;
            boolean check = true;
            for(int k=0;k<list.size();k++){
                if(list.get(k)==self && (k==0||k==list.size()-1)){
                    if(map.get(list.get(k))>1) average+=list.get(k);
                    else check = false;
                }
                else{
                    average+=list.get(k);
                }
            }
            if(!check) average = average/(scores[i].length-1);
            else average = average/scores[i].length;
            grade.add(average);
        }

        for(Double g:grade){
            if(g>=90) answer+="A";
            else if(g<90 && g>=80) answer+="B";
            else if(g<80 && g>=70) answer+="C";
            else if(g<70 && g>=50) answer+="D";
            else answer+="F";
        }

        return answer;
    }
}
