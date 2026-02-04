import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // BufferedReader는 입력 스트림을 버퍼링하여 읽기 속도를 높입니다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 한 줄을 읽어와서 공백(기본값) 단위로 분리합니다.
        String line = br.readLine();
        if (line != null) {
            StringTokenizer st = new StringTokenizer(line);

            // 두 개의 정수를 읽어 합산합니다.
            if (st.countTokens() >= 2) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                System.out.println(a + b);
            }
        }
    }
}