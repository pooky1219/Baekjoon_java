import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i < n; i++) {
            // 스택 비어있지 않고 가격 내려갔으면 체크
            while(!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                int index = stack.pop();
                answer[index] = i - index;
            }
            
            // 스택에 현재 인덱스 넣기
            stack.push(i);
        }
        
        // 스택에 남아있는 것들도 초 체크
        while(!stack.isEmpty()) {
            int index = stack.pop();
            answer[index] = n - index - 1;
        }
        
        return answer;
    }
}