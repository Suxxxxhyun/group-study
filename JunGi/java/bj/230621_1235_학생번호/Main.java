/** 2023.06.21
 * 20:08 ~ 20:27
 * 
 *
 */
import java.util.*;
import java.io.*;

public class Main {
	private static int N;
	private static String[] studentNums;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		studentNums = new String[N];
		for (int i = 0; i < N; i++) {
			studentNums[i] = br.readLine();
		}
		int answer = calculateMinK();
		System.out.println(answer);
	}

	// O(반복횟수 * 학생번호개수 * substring) -> O(N* K * K) -> O(N*M*M)
	private static int calculateMinK() {
		int K = 1;
		while (K <= studentNums[0].length()) {
			Set<String> nums = new HashSet<>();
			for (String studentNum : studentNums) {
				// 1. N개의 학생번호를 뒤에서부터 K길이로 자른다.
				String studentNumKLength = studentNum.substring(studentNum.length() - K, studentNum.length());
				// 2. Set에 넣어서 중복여부를 검출한다.
				nums.add(studentNumKLength);
			}

			// 3. 중복이 없으면 종료한다.
			if (nums.size() == N) {
				break;
			}
			// 4. 중복이 있으면 K를 1증가시키고 반복한다.
			K++;
		}
		return K;
	}
}
