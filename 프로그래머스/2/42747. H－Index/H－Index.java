import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        // 정렬
        Arrays.sort(citations);
        
        // h번 이상 인용된 논문 h편 이상
        // h번 이하 인용된 논문 h편 이하
        int n = citations.length;
        for(int i = 0; i < n; i++) {
            if(citations[i] >= n - i) {
                answer = n - i;
                break;
            }
        }
        
        return answer;
    }
}