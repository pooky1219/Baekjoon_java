import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int H, W; // 맵 크기(H x W)
	static int r, c; // 전차 위치
	static char[][] map; // 맵
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			
			map = new char[H][W];
			// 시작위치
			r = 0;
			c = 0;
			for(int i = 0; i < H; i++) {
				map[i] = br.readLine().toCharArray();
				for(int j = 0; j < W; j++) {
					if(map[i][j] == '^' || map[i][j] == 'v' || map[i][j] == '<' || map[i][j] == '>') {
						r = i;
						c = j;
					}
				}
			}
			
			int N = Integer.parseInt(br.readLine());
			String s = br.readLine();
			
			for(int i = 0; i < N; i++) {
				char next = s.charAt(i);
				move(next);
			}
			for(int i = 0; i < H; i++) {
				for(int j = 0; j < W; j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
		}// test case
		System.out.println(sb.toString());
	}// main
	
	static void move(char behavior) {
		int row = r;
		int col = c;
		switch(behavior) {
		case 'U':
			if(row - 1 >= 0 && map[row-1][col] == '.') {
				map[row-1][col] = '^';
				map[row][col] = '.';
				r = row - 1;
			} else
				map[row][col] = '^';
			break;
		case 'D':
			if(row + 1 < H && map[row+1][col] == '.') {
				map[row+1][col] = 'v';
				map[row][col] = '.';
				r = row+1;
			} else
				map[row][col] = 'v';
			break;
		case 'L':
			if(col - 1 >= 0 && map[row][col-1] == '.') {
				map[row][col-1] = '<';
				map[row][col] = '.';
				c = col-1;
			} else
				map[row][col] = '<';
			break;
		case 'R':
			if(col + 1 < W && map[row][col+1] == '.') {
				map[row][col+1] = '>';
				map[row][col] = '.';
				c = col+1;
			} else
				map[row][col] = '>';
			break;
		case 'S':
			if(map[row][col] == '^') {
				while(--row >= 0) {
					if(map[row][col] == '*') {
						map[row][col] = '.';
						break;
					} else if(map[row][col] == '#')
						break;
				}
			}
			else if(map[row][col] == 'v') {
				while(++row < H) {
					if(map[row][col] == '*') {
						map[row][col] = '.';
						break;
					} else if(map[row][col] == '#')
						break;
				}
			}
			else if(map[row][col] == '<') {
				while(--col >= 0) {
					if(map[row][col] == '*') {
						map[row][col] = '.';
						break;
					} else if(map[row][col] == '#')
						break;
				}
			}
			else {// '>'
				while(++col < W) {
					if(map[row][col] == '*') {
						map[row][col] = '.';
						break;
					} else if(map[row][col] == '#')
						break;
				}
			}
		}
	}
}
