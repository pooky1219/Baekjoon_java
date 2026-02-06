import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력을 빠르게 받기 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스의 개수 T 입력
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            // L, R, S 입력 (범위가 크므로 안전하게 long 사용 권장, 문제 조건상 int도 가능하지만 long이 안전)
            long L = Long.parseLong(st.nextToken());
            long R = Long.parseLong(st.nextToken());
            long S = Long.parseLong(st.nextToken());

            // 1. 오른쪽 보물(R)까지 걸리는 단계 수 계산
            // 규칙: 오른쪽으로 거리 k만큼 떨어진 곳은 2*k 단계에 도착
            long stepsToR = (R - S) * 2;

            // 2. 왼쪽 보물(L)까지 걸리는 단계 수 계산
            // 규칙: 왼쪽으로 거리 k만큼 떨어진 곳은 2*k + 1 단계에 도착
            long stepsToL = (S - L) * 2 + 1;

            // 두 경우 중 더 빨리 끝나는(작은) 값을 결과에 추가
            sb.append(Math.min(stepsToR, stepsToL)).append("\n");
        }

        // 전체 결과 출력
        System.out.print(sb);
    }
}