import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 1. 처음 폭탄을 들고 있는 사람 K 입력
        int K = Integer.parseInt(br.readLine());
        
        // 2. 질문의 개수 N 입력
        int N = Integer.parseInt(br.readLine());
        
        int currentTime = 0; // 경과 시간 누적 변수
        
        // 3. N개의 질문 처리
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int timeTaken = Integer.parseInt(st.nextToken());
            String answer = st.nextToken();
            
            // 시간을 더함
            currentTime += timeTaken;
            
            // 폭탄이 터지는 시간(210초)을 지났는지 확인
            if (currentTime >= 210) {
                // 터졌다면 현재 폭탄을 쥐고 있는 사람(K) 출력 후 종료
                System.out.println(K);
                return;
            }
            
            // 아직 안 터졌다면 대답에 따라 폭탄 이동 처리
            if (answer.equals("T")) {
                // 정답(T)인 경우에만 다음 사람에게 넘김
                K++;
                // 8번 다음은 1번으로 돌아감
                if (K > 8) {
                    K = 1;
                }
            }
            // 'N'(오답)이나 'P'(패스)인 경우 폭탄은 그대로 현재 플레이어가 가짐
        }
    }
}