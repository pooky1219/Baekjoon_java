import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 빠른 입출력을 위해 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 1. N 입력 및 배열 초기화
        int N = Integer.parseInt(br.readLine());
        int[] flowers = new int[N]; // 0 ~ N-1 인덱스 사용

        // 2. 초기 꽃 정보 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            flowers[i] = Integer.parseInt(st.nextToken());
        }

        // 3. 쿼리 수 Q 입력
        int Q = Integer.parseInt(br.readLine());

        // 4. 쿼리 처리
        while (Q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken()) - 1; // 0-based 인덱스로 변환
            int r = Integer.parseInt(st.nextToken()) - 1; // 0-based 인덱스로 변환

            if (type == 1) {
                // 1번 쿼리: l부터 r까지 k인 꽃의 개수 세기
                int k = Integer.parseInt(st.nextToken());
                int count = 0;
                for (int i = l; i <= r; i++) {
                    if (flowers[i] == k) {
                        count++;
                    }
                }
                sb.append(count).append("\n");
            } else {
                // 2번 쿼리: l부터 r까지 꽃 없애기 (0으로 설정)
                for (int i = l; i <= r; i++) {
                    flowers[i] = 0; // 꽃이 없음을 0으로 표시
                }
            }
        }

        // 결과 출력
        System.out.print(sb);
    }
}