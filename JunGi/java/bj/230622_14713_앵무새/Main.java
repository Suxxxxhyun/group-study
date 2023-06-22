/** 2023.06.22 (16:45 ~ 56(설계) ~ 17:10 (fail)) -> 게시판 보고 해결
 * 문제 조건이 좀 부족한듯?
 * edge case: 앵무새의 모든 단어와 cseterm 모든 단어의 다른 경우
 * 
 * type: 큐 활용 + 구현
 */
import java.io.*;
import java.util.*;

public class Main {
	private static int birdTotalWord = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		List<Queue<String>> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			list.add(new LinkedList<>());
		}

		for (int i = 0; i < N; i++) {
			Queue<String> queue = list.get(i);
			String[] words = br.readLine().split(" ");
			birdTotalWord += words.length;
			for (String w : words) {
				queue.add(w);
			}
		}

		String[] cseteram = br.readLine().split(" ");
		if (birdTotalWord != cseteram.length) {
			System.out.println("Impossible");
		} else {
			String result = pro(list, cseteram);
			System.out.println(result);
		}
	}

	private static String pro(List<Queue<String>> list, String[] cseteram) {
		for (String s : cseteram) {
//			System.out.println("현재 단어: " + s);
			for (int idx = 0; idx < list.size(); idx++) {

				Queue<String> queue = list.get(idx);
//				System.out.println("queue.peek(): " + queue.peek());
				if (!queue.isEmpty() && queue.peek().equals(s)) {
//					System.out.println("queue.peek(): " + queue.peek());
					queue.poll();
					break;
				}
				if (idx == list.size() - 1) {
					return "Impossible";
				}
			}
//			System.out.println("종료 후, 앵무새 큐 상황");
		}
		return "Possible";
	}

	private static void printAllQueue(List<Queue<String>> list) {
		for (Queue<String> q : list) {
			System.out.println(q);
		}
	}
}
