import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 1. 테스트 케이스 개수 T 입력
        int T = Integer.parseInt(br.readLine());
        
        // 2. 종족별 점수 설정 (문제 기준)
        // 간달프: 호빗(1), 인간(2), 엘프(3), 드워프(3), 독수리(4), 마법사(10)
        int[] goodScores = {1, 2, 3, 3, 4, 10};
        // 사우론: 오크(1), 인간(2), 워그(2), 고블린(2), 우럭하이(3), 트롤(5), 마법사(10)
        int[] evilScores = {1, 2, 2, 2, 3, 5, 10};
        
        StringBuilder sb = new StringBuilder();
        
        for (int t = 1; t <= T; t++) {
            // 간달프 군대 점수 계산
            StringTokenizer st = new StringTokenizer(br.readLine());
            int goodTotal = 0;
            for (int i = 0; i < 6; i++) {
                goodTotal += Integer.parseInt(st.nextToken()) * goodScores[i];
            }
            
            // 사우론 군대 점수 계산
            st = new StringTokenizer(br.readLine());
            int evilTotal = 0;
            for (int i = 0; i < 7; i++) {
                evilTotal += Integer.parseInt(st.nextToken()) * evilScores[i];
            }
            
            // 3. 결과 판정 및 문구 작성
            sb.append("Battle ").append(t).append(": ");
            if (goodTotal > evilTotal) {
                sb.append("Good triumphs over Evil\n");
            } else if (evilTotal > goodTotal) {
                sb.append("Evil eradicates all trace of Good\n");
            } else {
                sb.append("No victor on this battle field\n");
            }
        }
        
        // 4. 최종 결과 출력
        System.out.print(sb.toString());
    }
}