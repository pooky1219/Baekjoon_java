import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        // commands의 행 개수만큼 반목하면서 K번째수 계산
        for(int l = 0; l < commands.length; l++) {
            int i = commands[l][0];
            int j = commands[l][1];
            int k = commands[l][2];
            
            // 새 배열에 원소 넣기
            int[] newArray = new int[j - i + 1];
            for(int m = 0; m < newArray.length; m++) {
                newArray[m] = array[m + i - 1];
            }
            
            // 정렬
            Arrays.sort(newArray);
            
            answer[l] = newArray[k - 1];
        }
        return answer;
    }
}