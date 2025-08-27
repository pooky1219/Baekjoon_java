import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		// 체스판 입력
		char[][] arr = new char[N][M];
		for(int i = 0; i < arr.length; i++) {
			st = new StringTokenizer(br.readLine());
			String line = st.nextToken();
			for(int j = 0; j < arr[i].length; j++)
				arr[i][j] = line.charAt(j);
		}
		
		// 바꿔야할 최소 개수
		int min = Integer.MAX_VALUE;
		
		// 8 x 8만 체크하기 위한 for문
		for(int i = 0; i <= N - 8; i++) {
			for(int j = 0; j <= M - 8; j++) {
				// 8 x 8 체스판 탐색
				int countB = 0;
				int countW = 0;

				for(int r = i; r < i+8; r++) {
					for(int c = j; c < j+8; c++) {
						// 예상 색깔과 보드판 색깔이 맞는지 체크
						char expectedColor = ((r+c) % 2 == 0) ? 'B' : 'W';
						if(expectedColor != arr[r][c])
							countB++;
						// w로 칠하는 것은 64에서 흰색으로 칠하는 횟수를 뺀 것
						countW = 64 - countB;
					}
				}
				min = Math.min(min, Math.min(countB, countW));
			}// j
		}// i
		
		System.out.println(min);
	}
}
