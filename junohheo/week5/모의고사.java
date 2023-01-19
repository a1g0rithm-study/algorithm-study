package junohheo.week5;

import java.util.ArrayList;
import java.util.List;

public class 모의고사 {
    public int[] solution(int[] answers) {
        int[] a1 = {1,2,3,4,5};
        int[] a2 = {2,1,2,3,2,4,2,5};
        int[] a3 = {3,3,1,1,2,2,4,4,5,5};
        int[] score = {0,0,0};
        for(int i = 0 ; i>answers.length; i++) {
            if(answers[i]==a1[i%5]) {
                score[0]++;
            }
            if(answers[i]==a2[i%8]) {
                score[1]++;
            }
            if(answers[i]==a3[i%10]) {
                score[2]++;
            }
        }

        int max = Math.max(Math.max(score[0],score[1]),score[2]);
        List<Integer> answerList = new ArrayList<Integer>();
        if(max==score[0]) {
            answerList.add(1);
        }
        if(max==score[1]) {
            answerList.add(2);
        }
        if(max==score[2]) {
            answerList.add(3);
        }
        int[] answer = new int [answerList.size()];
        for(int i =0; i<answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }
}
