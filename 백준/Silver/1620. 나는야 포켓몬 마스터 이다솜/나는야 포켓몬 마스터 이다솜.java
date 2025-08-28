import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		// N : # of pocketmon / M : # of problem
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// 해쉬맵 생성
		// pocketmonDir1 : 번호 -> 포켓몬
		// pocketmonDir2 : 포켓몬 -> 번호
		HashMap<Integer, String> pocketmonDir1 = new HashMap<>();
		HashMap<String, Integer> pocketmonDir2 = new HashMap<>();
		
		// 도감 생성
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			String pocketmon = st.nextToken();
			pocketmonDir1.put(i, pocketmon);
			pocketmonDir2.put(pocketmon, i);
		}
		
		// 문제 맞추기
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			String line  = st.nextToken();
			// 첫 글자가 숫자라면 숫자로 변환
			if(line.charAt(0) >= '0' && line.charAt(0) <= '9') {
				int num = Integer.parseInt(line);
				sb.append(pocketmonDir1.get(num) + "\n");
			} else {
				sb.append(pocketmonDir2.get(line) + "\n");
			}
		}
		System.out.println(sb.toString());
	}
}
