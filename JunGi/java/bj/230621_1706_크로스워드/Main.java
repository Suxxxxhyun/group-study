/** 2023.06.21 (21:37 ~ 22:03)
 *
 */
import java.io.*;
import java.util.*;

public class Main {
	private static int R, C;
	private static List<String> words = new ArrayList<>();
	private static char[][] board;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		R = Integer.parseInt(temp[0]);
		C = Integer.parseInt(temp[1]);

		board = new char[R][C];
		for (int row = 0; row < R; row++) {
			String info = br.readLine();
			for (int col = 0; col < C; col++) {
				board[row][col] = info.charAt(col);
			}
		}
		String result = pro();
		System.out.println(result);
	}

	private static String pro() {
		String result = "";
		// 1. 길이가 2이상인 가로낱말 구하기
		updateRowWord();
		// 2. 길이가 2이상인 세로낱말 구하기
		updateColWord();
		// 3. 사전순 정렬
		Collections.sort(words);
		return words.get(0);
	}

	private static void updateRowWord() {
		for (int row = 0; row < R; row++) {
			StringBuilder sb = new StringBuilder();
			for (int col = 0; col < C; col++) {
				char c = board[row][col];
				// # 만날때까지 sb에 알파벳 append하고
				if(c != '#') {
					sb.append(c);
				} else {
				// # 만나면 
					//sb 길이가 2이상이면 추가
					if(sb.length() >= 2) {
						words.add(sb.toString());
					}
					//sb초기화
						sb.setLength(0);
				}
				//끝에 도달하면 한번더 확인	
				if(col == C-1 && sb.length() >= 2) {
					words.add(sb.toString());
				}
			}
		}
	}
	
	private static void updateColWord() {
		for (int col = 0; col < C; col++) {
			StringBuilder sb = new StringBuilder();
			for (int row = 0; row < R; row++) {
				char c = board[row][col];
				// # 만날때까지 sb에 알파벳 append하고
				if(c != '#') {
					sb.append(c);
				} else {
				// # 만나면 
					//sb 길이가 2이상이면 추가
					if(sb.length() >= 2) {
						words.add(sb.toString());
					}
					//sb초기화
						sb.setLength(0);
				}
				//끝에 도달하면 한번더 확인	
				if(row == R-1 && sb.length() >= 2) {
					words.add(sb.toString());
				}
			}
		}
	}
}
