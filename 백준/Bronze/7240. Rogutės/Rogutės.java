import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 첫 번째 줄: N(구간 수)과 S(제한 속도) 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        
        int currentSpeed = 0; // 초기 속도는 0
        
        for (int i = 0; i < N; i++) {
            // 각 구간에서의 속도 변화량 ai
            int ai = Integer.parseInt(br.readLine());
            currentSpeed += ai;
            
            // 스마트 제동 규칙:
            // 1. 구간의 끝에서 속도가 S를 초과하는가?
            // 2. 현재가 마지막 구간(N-1)이 아닌가?
            if (i < N - 1) { // 마지막 구간이 아닐 때만 체크
                if (currentSpeed > S) {
                    currentSpeed -= 1;
                }
            }
        }
        
        // 최종 속도 출력
        System.out.println(currentSpeed);
    }
}