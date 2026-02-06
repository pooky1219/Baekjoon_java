import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 빠른 입력을 위해 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 첫 번째 줄: N 입력 (사용하지 않아도 되지만 입력 형식상 받아줍니다)
        int N = Integer.parseInt(br.readLine());
        
        // 두 번째 줄: N일 동안 푼 문제 수 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int maxStreak = 0;    // 최장 스트릭 저장 변수
        int currentStreak = 0; // 현재 진행 중인 스트릭 저장 변수
        
        // N번 반복하며 각 날짜의 문제 수 확인
        for (int i = 0; i < N; i++) {
            int solvedCount = Integer.parseInt(st.nextToken());
            
            if (solvedCount > 0) {
                // 문제를 1문제 이상 풀었으면 스트릭 증가
                currentStreak++;
                
                // 최장 스트릭 갱신
                if (currentStreak > maxStreak) {
                    maxStreak = currentStreak;
                }
            } else {
                // 0문제 풀었으면 스트릭 초기화
                currentStreak = 0;
            }
        }
        
        // 결과 출력
        System.out.println(maxStreak);
    }
}