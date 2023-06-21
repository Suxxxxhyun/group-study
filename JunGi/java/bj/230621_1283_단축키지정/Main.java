import java.io.*;
import java.util.*;

/**
 * 2023.06.21 (20:32 ~ 21:00)
 * Goal: N개의 옵션을 출력하는데 단축키로 지정된 알파벳은 좌우에 [] 괄호 씌워서 출력
 * Type: 구현, 문자열
 * 
 * [설계]
 * 1. 현재 옵션에 대해 단축키를 확인한다.
 * 	1) 단어의 첫 글자로 확인한다. return: 단축키idx or -1
 *  2) 없으면(-1) 각 알파벳으로 확인한다. return: 단축키idx or -1 
 * 2. 단축키 없으면(-1) 그대로 출력
 * 3. 있으면 변환하여 출력
 * 4. [] 괄호씌운 변환기
 * 
 * ** 단축키는 대소문자 구분 X ** -> ascii 코드로 대문자로 통일
 * 
 *
 */
public class Main {
	private static Set<Character> hotKeys = new HashSet<>();

	public static void main(String[] args) throws IOException {
//		System.out.println("a: " + (int)'a');
//		System.out.println("A: " + (int)'A');
//		
//		System.out.println("z: " + (int)'z');
		String result = pro();
		System.out.println(result);
	}

	private static String pro() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < N; i++) {
			String option = br.readLine();
			int hotKeyIdx = findHotKey1Idx(option);
			if(hotKeyIdx == -1) {
				hotKeyIdx = findHotKey2Idx(option);
			}
			if(hotKeyIdx == -1) {
				sb.append(option).append("\n");
			} else {
				String converted = converter(option, hotKeyIdx);
				sb.append(converted).append("\n");
			}
		}
		String result = sb.toString();
		return result;
	}

	private static int findHotKey1Idx(String option) {
		for (int i = 0; i < option.length(); i++) {
			char c = option.charAt(i);
			if (c == ' ') {
				continue;
			}
			if(isLowerCase(c)) {
				c = (char) (c - 32);
			}
			// 각 단어의 첫번째 글자
			if (i == 0 || (i != 0 && option.charAt(i - 1) == ' ')) {
				if (!hotKeys.contains(c)) {
					hotKeys.add(c);
					return i;
				}
			}
		}
		return -1;
	}

	private static int findHotKey2Idx(String option) {
		for (int i = 0; i < option.length(); i++) {
			char c = option.charAt(i);
			if (c == ' ') {
				continue;
			}
			if(isLowerCase(c)) {
				c = (char) (c - 32);
			}
			if (!hotKeys.contains(c)) {
				hotKeys.add(c);
				return i;
			}
		}
		return -1;
	}

	private static String converter(String str, int idx) {
		return str.substring(0, idx) + "[" + str.charAt(idx) + "]" + str.substring(idx + 1, str.length());
	}
	
	private static boolean isLowerCase(char c) {
		return 'a' <= c && c <= 'z';
	}
}
