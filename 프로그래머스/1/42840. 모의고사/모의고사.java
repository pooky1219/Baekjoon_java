import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] supoja1 = new int[] {1, 2, 3, 4, 5};
        int[] supoja2 = new int[] {2, 1, 2, 3, 2, 4, 2, 5};
        int[] supoja3 = new int[] {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        // 정답 개수 체크
        int[] answerArr = new int[3]; // 수포자 1의 정답 수
        for(int i = 0; i < answers.length; i++) {
            int correctAnswer = answers[i];
            if(correctAnswer == supoja1[i % supoja1.length])
                answerArr[0]++;
            if(correctAnswer == supoja2[i % supoja2.length])
                answerArr[1]++;
            if(correctAnswer == supoja3[i % supoja3.length])
                answerArr[2]++;
        }
        
        // 최대 점수 저장
        int max = Math.max(answerArr[0], answerArr[1]);
        max = Math.max(max, answerArr[2]);
        
        // 최대 점수 맞은 사람 저장
        List<Integer> temp = new ArrayList<>();
        for(int i = 0; i < answerArr.length; i++) {
            if(answerArr[i] == max)
                temp.add(i + 1);
        }
        
        // 배열로 변환
        int[] answer = new int[temp.size()];
        for(int i = 0; i < temp.size(); i++) {
            answer[i] = temp.get(i);
        }
        
        return answer;
    }
}