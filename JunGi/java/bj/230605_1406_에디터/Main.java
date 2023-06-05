import java.util.*;
import java.io.*;

/** 2023.06.05
 * [리뷰]
 * 30분 고민하고 모르겠어서 풀이 참고함
 * 
 * [알게된 내용]
 * 1. ListIterator: 
 * - 기존 iterator에 <- 방향 이동기능 추가
 * 2. ArrayList vs LinkedList:
 * - 둘다 add() 자체의 시간복잡도는 O(1)이지만, ArrayList의 경우 초기 배열 크기는 10이고 이 후 resize하는 과정에서 시간적 비효율이 발생함
 * - ArrayList로 구현시, 시간초과
 * - LinkedList로 구현시, 시간초과
 * - 결론: element 개수가 많고, add operation만 한다면 linkedList를 고려
 *
 */
public class BOJ1406_에디터 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] temp = br.readLine().toCharArray();
		int orderCount = Integer.parseInt(br.readLine());

//		List<Character> str = new ArrayList<>(); // -> 시간초과
		List<Character> str = new LinkedList<>();
		for (char c : temp) {
			str.add(c);
		}

		ListIterator<Character> iter = str.listIterator();
		while (iter.hasNext()) {
			iter.next();
		}

		for (int i = 0; i < orderCount; i++) {
			String orderInfo = br.readLine();
			char order = orderInfo.charAt(0);
			if (order == 'L') {
				if (iter.hasPrevious()) {
					iter.previous();
				}
			} else if (order == 'D') {
				if (iter.hasNext()) {
					iter.next();
				}
			} else if (order == 'B') {
				if (iter.hasPrevious()) {
					iter.previous();
					iter.remove();
				}
			} else {
				char newChar = orderInfo.charAt(2);
				iter.add(newChar);
			}
		}

		StringBuilder result = new StringBuilder(60000);
		for(char c: str) {
			result.append(c);
		}
//		String
		System.out.println(result);
	}
}
