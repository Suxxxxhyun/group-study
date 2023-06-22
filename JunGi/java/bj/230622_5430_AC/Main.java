package 문자열;

/** 2023.06.22 (13:00 ~ 13:40)
 * ** 시간복잡도를 고려해야 하는 문제**
 * ** 어떻게 최적화할 수 있을지 고민해야 함**
 * 
 * [유형]
 * Goal: 테스트케이스별 수행할 함수 P, 배열의 초깃값이 주어질 때, 최종결과 구하기
 * -> 입력값 범위에 따라 직접 구현하는 방식은 무조건 시간초과 발생
 * -> 최적화 필요
 * 
 * [설계]
 * * edge case: n < D의 개수 --> error
 * * 초기화: first=0, last=n-1
 * 1. R을 만나면 rCount 증가
 * 2. D를 만나면
 * 	1) rCount가 홀수면 -> last-1
 * 	2) rCount가 짝수면 -> first + 1
 * 최종: rCount 홀수면 뒤에서부터 읽음 (last  ~ first)
 * 	 	rCount 짝수면 앞에서부터 읽음 (first ~ last)
 *
 */
import java.util.*;
import java.io.*;

public class BOJ5430_AC {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String order = br.readLine();
			int n = Integer.parseInt(br.readLine());
			int[] nums = initialArr(br.readLine(), n);

			String result = pro(nums, order);
			sb.append(result).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static String pro(int[] nums, String order) {
		// * edge case: n의 개수 < D의 개수 -> error
		if (isError(nums.length, order)) {
			return "error";
		}
		// * 초기화: first<-0, last<-n-1
		int first = 0, last = nums.length - 1, rCount = 0;
		for (char c : order.toCharArray()) {
			// 1. R을 만나면 rCount증가
			if (c == 'R') {
				rCount++;
			} else {// 2. D를 만나면
				// rCount 홀수면 -> last -= 1
				if (rCount % 2 == 1) {
					last -= 1;
				} else {
					// rCount 짝수면 -> first += 1
					first += 1;
				}
			}
		}
		String answer = getAnswer(first, last, rCount, nums);
		return answer;
	}

	private static String getAnswer(int first, int last, int rCount, int[] nums) {
		StringBuilder sb = new StringBuilder("[");
		// rCount가 홀수면 뒤에서부터
		if (rCount % 2 == 1) {
			for (int i = last; i >= first; i--) {
				if (i != first) {
					sb.append(nums[i]).append(",");
				} else {
					sb.append(nums[i]);
				}
			}
		} else {
			// rCount가 짝수면 앞에서부터
			for (int i = first; i <= last; i++) {
				if (i != last) {
					sb.append(nums[i]).append(",");
				} else {
					sb.append(nums[i]);
				}
			}
		}
		String answer = sb.append("]").toString();
		return answer;
	}

	private static int[] initialArr(String input, int n) {
		String[] parsed = input.replace("[", "").replace("]", "").split(",");
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(parsed[i]);
		}
		return arr;
	}

	private static boolean isError(int n, String order) {
		int dCount = getDCount(order);
		return n < dCount;
	}

	private static int getDCount(String order) {
		int dCount = 0;
		for (char c : order.toCharArray()) {
			if (c == 'D') {
				dCount++;
			}
		}
		return dCount;
	}

}
