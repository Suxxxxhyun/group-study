/** 2023.06.22 (13:39 ~ 14:12) (2fail -> 반례확인 -> solve)
 * -> int overflow 체크 못함
 * -> 10^n 꼴이기 때문에 overflow 발생
 * -> getMax로직은 long 으로 처리
 * -> getMin은 String으로 처리해서 ㄱㅊ
 * 
 * [유형]
 * Goal: 민겸수 -> 십진수 변환시, 가질 수 있는 값 중 max, min 구하기
 * 
 * ex. MKKMMK
 * max: 505500
 * min: 155105
 * 
 * min: 연속된 M은 100...00 꼴이 제일 작다. 
 * ex) MMMMK -> 10005
 * -> 연속된 M은 1000..0처리, K는 5처리
 * 
 * max: MM...MK -> 500..00 처리가 가장 크다
 * -> MM...MMK는 50...000 처리
 * -> 단, ...MKMMM 처럼 M으로 끝나는 경우는 예외처리
 */
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String minkyum = br.readLine();
		String min = getMin(minkyum);
		String max = getMax(minkyum);
		System.out.println(max);
		System.out.println(min);
	}

	// 아이디어: 연속된 M은 100..0이 제일 작다.
	private static String getMin(String minkyum) {
		StringBuilder sb = new StringBuilder();
		boolean mFlag = false;
		for (char c : minkyum.toCharArray()) {
			if (c == 'M') {
				if (!mFlag) {
					mFlag = true;
					sb.append("1");
				} else {
					sb.append("0");
				}
			} else {
				mFlag = false;
				sb.append("5");
			}
		}
		return sb.toString();
	}

	private static String getMax(String minkyum) {
		StringBuilder sb = new StringBuilder();
		int mCount = 0;
		for (int idx = 0; idx < minkyum.length(); idx++) {
			char c = minkyum.charAt(idx);
			// M이면 M의 개수를 센다.
			if (c == 'M') {
				mCount++;
				// M인데 마지막이면 ...MMM or ..KM -> M의 개수만큼 1을 append한다.
				if (idx == minkyum.length() - 1) {
					for (int i = 0; i < mCount; i++) {
						sb.append("1");
					}
				}
			} else {
				// K이면 10^M의 개수 * 5를 append하고, M의 개수를 0으로 초기화한다.
				long temp = (long) (Math.pow(10, mCount) * 5);
				sb.append(temp);
				mCount = 0;
			}
		}
		return sb.toString();
	}
}
