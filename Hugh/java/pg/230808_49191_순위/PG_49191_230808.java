package Programmers.Lv2;
import java.util.*;

/*
    10:31~

    *Graph*
    (블로그 참조)
    플로이드 와샬(Floyd Warshall) - '모든 정점'에서 '모든 정점'으로의 최단 경로

    - X에서 Y로 가는 최소 비용 vs X에서 노드 1로 가는 비용 + 노드 1에서 Y로 가는 비용

    A 선수가 B 선수를 이김

    N^3 (100^3)

*/

public class PG_49191_230808 {
    static int[][] arr;
    public int solution(int n, int[][] results) {
        int answer = 0;

        arr = new int[n+1][n+1];
        for (int i = 0; i < results.length; i++) {
            arr[results[i][0]][results[i][1]] = 1; // A -> B
            arr[results[i][1]][results[i][0]] = -1; // B -> A

        }

        // 1 -> 2 이고 2 -> 5 이면 1 -> 5 이다.
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    if (arr[i][k] == 1 && arr[k][j] == 1) {
                        arr[i][j] = 1; // 1 -> 5 (이김)
                        arr[j][i] = -1; // 5 -> 1 (짐)
                    }

                    if (arr[i][k] == -1 && arr[k][j] == -1) {
                        arr[i][j] = -1; // 1 -> 5 (짐)
                        arr[j][i] = 1; // 5 -> 1 (이김)
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            int cnt = 0;
            for (int j = 1; j <= n; j++) {
                if (arr[i][j] != 0) {
                    cnt++;
                }
            }

            if (cnt == n-1) answer++;
        }

        return answer;
    }
}
