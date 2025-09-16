import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Set<String> notListen = new HashSet<>();
		List<String> wordList = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			notListen.add(br.readLine());
		}
		
		// 겹치는지 체크
		int cnt = 0;
		for(int i = 0; i < M; i++) {
			String word = br.readLine();
			if(notListen.contains(word)) {
				wordList.add(word);
				cnt++;
			}
		}
		// 정렬
		wordList.sort(null);
		sb.append(cnt).append("\n");
		for(int i = 0; i < wordList.size(); i++) {
			sb.append(wordList.get(i)).append("\n");
		}
		System.out.println(sb.toString());
	}
}
