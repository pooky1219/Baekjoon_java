import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 음표의 개수 N 입력
        int n = sc.nextInt();
        
        double totalLength = 0.0;

        for (int i = 0; i < n; i++) {
            int code = sc.nextInt();

            // 코드에 따른 박자 계산
            if (code == 0) {
                totalLength += 2.0;
            } else if (code == 1) {
                totalLength += 1.0;
            } else {
                // 2, 4, 8, 16 등은 1/code로 계산
                totalLength += 1.0 / code;
            }
        }

        // 결과 출력 (오차 범위 10^-6 이내)
        System.out.printf("%.6f\n", totalLength);
        
        sc.close();
    }
}