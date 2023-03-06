import java.util.*;

public class Programmers아이템줍기 {
	static int[][] map;
	static boolean[][] visited;

	public static int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
		int answer = 0;
		int n = 200;
		int m = 200;

		map = new int[n][m];
		visited = new boolean[n][m];

		for (int i = 0; i < rectangle.length; i++) {
			int x1 = rectangle[i][0] * 2;
			int y1 = rectangle[i][1] * 2;
			int x2 = rectangle[i][2] * 2;
			int y2 = rectangle[i][3] * 2;

			for (int j = x1; j <= x2; j++) {
				for (int k = y1; k <= y2; k++) {
					map[j][k] = 7;
				}
			}
		}

		for (int i = 0; i < rectangle.length; i++) {
			int x1 = rectangle[i][0] * 2;
			int y1 = rectangle[i][1] * 2;
			int x2 = rectangle[i][2] * 2;
			int y2 = rectangle[i][3] * 2;

			for (int j = x1 + 1; j <= x2 - 1; j++) {
				for (int k = y1 + 1; k <= y2 - 1; k++) {
					map[j][k] = 0;
				}
			}
		}

		answer = bfs(characterX, characterY, itemX, itemY, n, m);

		return answer;
	}

	private static int bfs(int characterX, int characterY, int itemX, int itemY, int n, int m) {
		Queue<Node> q = new LinkedList<>();
		int cX = characterX * 2;
		int cY = characterY * 2;
		int iX = itemX * 2;
		int iY = itemY * 2;

		q.offer(new Node(cX, cY, 0));
		visited[cX][cY] = true;

		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };

		while (!q.isEmpty()) {
			Node now = q.poll();

			if (now.x == iX && now.y == iY)
				return now.cnt / 2;

			for (int i = 0; i < 4; i++) {
				int x = now.x + dx[i];
				int y = now.y + dy[i];

				if (0 > x || x >= n || 0 > y || y >= m)
					continue;

				if (7 == map[x][y] && !visited[x][y]) {
					visited[x][y] = true;
					q.offer(new Node(x, y, now.cnt + 1));
					map[x][y] = 2;
				}
			}
		}

		return -1;
	}

	static class Node {
		int x;
		int y;
		int cnt;

		public Node(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
}
