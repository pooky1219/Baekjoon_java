import java.util.*;

class Solution {
    static class Word {
        String word;
        int cnt;
        
        public Word(String word, int cnt) {
            this.word = word;
            this.cnt = cnt;
        }
    }
    public int solution(String begin, String target, String[] words) {
        // 방문배열
        boolean[] visited = new boolean[words.length];
        
        // bfsㄱㄱ
        Queue<Word> q = new ArrayDeque<>();
        q.offer(new Word(begin, 0));
        
        while(!q.isEmpty()) {
            Word cur = q.poll();
            String word = cur.word;
            int cnt = cur.cnt;
            
            // 단어가 target과 같다면 cnt를 return
            if(word.equals(target))
                return cnt;
            
            // 아니라면 다음 단어로 이동
            for(int i = 0; i < words.length; i++) {
                // 방문한곳이면 패스
                if(visited[i])
                    continue;
                
                // 문자가 다르면 differ +1
                int differ = 0;
                String next = words[i];
                
                for(int j = 0; j < word.length(); j++) {
                    if(word.charAt(j) != next.charAt(j))
                        differ++;
                }
                
                // differ가 2이상이면 패스
                if(differ >= 2)
                    continue;
                
                // 큐에 넣고 visited체크
                q.offer(new Word(next, cnt + 1));
                visited[i] = true;
            }
        }
        
        // 여기까지 왔다는 것은 변환이 불가하다는 것이므로 0을 return
        return 0;
    }
}