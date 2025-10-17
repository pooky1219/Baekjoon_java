import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr;
	static int whiteCnt, blueCnt; // 흰색, 파란색 개수
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N  = Integer.parseInt(br.readLine());
		// 종이 생성
		arr = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		whiteCnt = 0; blueCnt = 0;
		check(N, 0, 0);
		sb.append(whiteCnt).append("\n").append(blueCnt);
		System.out.println(sb);
	}// main
	
	static void check(int N, int row, int col) {
		// 사이즈가 1이면 무조건 종이 1개
		if(N == 1) {
			if(arr[row][col] == 0)
				whiteCnt++;
			else
				blueCnt++;
			return;
		}
		
		int num = arr[row][col];
		boolean isOk = true;
		loop:
		for(int i = row; i < row+N; i++) {
			for(int j = col; j < col+N; j++) {
				if(arr[i][j] != num) {
					isOk = false;
					break loop;
				}
			}
		}
		
		// 같지 않은게 있다면
		if(!isOk) {
			check(N/2, row, col);
			check(N/2, row+N/2, col);
			check(N/2, row, col+N/2);
			check(N/2, row+N/2, col+N/2);
		} else {
			if(num == 0)
				whiteCnt++;
			else
				blueCnt++;
			return;
		}
	}
}
