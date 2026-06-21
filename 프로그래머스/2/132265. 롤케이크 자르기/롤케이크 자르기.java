import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        // 철수와 동생의 토핑 세트
        HashMap<Integer, Integer> topping1 = new HashMap<>();
        HashMap<Integer, Integer> topping2 = new HashMap<>();
        
        // 우선 시작은 맨 앞이므로 동생의 토핑에 모든 것을 넣음
        for(int i = 0; i < topping.length; i++) {
            int cnt = topping2.getOrDefault(topping[i], 0);
            topping2.put(topping[i], cnt + 1);
        }
        
        // 철수의 토핑에 하나씩 추가하면서 사이즈 비교
        for(int i = 0; i < topping.length - 1; i++) {
            // 철수
            int cnt1 = topping1.getOrDefault(topping[i], 0);
            topping1.put(topping[i], cnt1 + 1);
            
            // 동생
            int cnt2 = topping2.get(topping[i]);
            // 토핑 뺐을 때 해당 토핑이 0이되면 제거
            int remain = cnt2 - 1;
            if(remain == 0)
                topping2.remove(topping[i]);
            else
                topping2.put(topping[i], remain);
            
            if(topping1.size() == topping2.size())
                answer++;
        }
        return answer;
    }
}