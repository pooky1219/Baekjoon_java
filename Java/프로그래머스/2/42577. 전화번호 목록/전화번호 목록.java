import java.util.*;

class Solution {
    public boolean solution(String[] phoneBook) {
        boolean answer = true;
        
        Map<String, Integer> numberMap = new HashMap<>();
        // Map에 폰 번호 넣기(conatinsKey를 사용하기 위함)
        for(int i = 0; i < phoneBook.length; i++) {
            numberMap.put(phoneBook[i], i);
        }
        
        loop:
        for(int i = 0; i < phoneBook.length; i++) {
            for(int j = 1; j < phoneBook[i].length(); j++) {
                // 맵에 접두어 존재하는지 확인
                String subStr = phoneBook[i].substring(0, j);
                if(numberMap.containsKey(subStr)) {
                    answer = false;
                    break loop;
                }
            }
        }
        return answer;
    }
}