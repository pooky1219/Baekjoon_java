import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. 총 문의 개수 N 입력 (최대 25억이므로 long 사용)
        long N = Long.parseLong(br.readLine());

        // 2. 첫 번째 문의 방법 입력 (0 또는 1)
        int start = Integer.parseInt(br.readLine());

        // 3. 모순 판별
        // 규칙 2(교차)와 규칙 4(3의 배수 동일)는 3번째와 6번째 문에서 충돌합니다.
        // 따라서 N이 6 이상이면 조건을 만족할 수 없습니다.
        if (N >= 6) {
            System.out.println("Love is open door");
        } else {
            // N이 5 이하인 경우, 단순히 0과 1을 번갈아가며 출력
            for (int i = 2; i <= N; i++) {
                // 0이면 1로, 1이면 0으로 스위칭 (1 - start 방식 사용)
                start = 1 - start;
                System.out.println(start);
            }
        }
    }
}