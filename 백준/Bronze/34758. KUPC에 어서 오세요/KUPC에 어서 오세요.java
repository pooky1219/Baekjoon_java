import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. 대회장 위치 (X, Y) 입력
        long X = sc.nextLong();
        long Y = sc.nextLong();

        // 2. 학생 수 N 입력
        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            // 3. i번째 학생 위치 (xi, yi) 입력
            long xi = sc.nextLong();
            long yi = sc.nextLong();

            // 4. 최소 방향 전환 횟수 판정
            // x좌표가 같거나 y좌표가 같으면 직선 이동이 가능하므로 0번
            if (xi == X || yi == Y) {
                System.out.println(0);
            } 
            // x, y 모두 다르면 기역(ㄱ)자 형태로 한 번만 꺾으면 됨
            else {
                System.out.println(1);
            }
        }

        sc.close();
    }
}