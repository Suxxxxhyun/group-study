package BOJ.FloydWarshall;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
    하나의 정점에서 모든 정점까지 최단경로 = 다익스트라
    음수사이클 = 벨만-포드
    모든 노드간 최단사이클 = 플로이드 와샬

    각 노드에대해 최단경로 사이클을 찾아야하므로 N:N 플로이드 와샬로 진행해보자.
    O(N^3) = 24,000,000 가능
 */
public class BOJ_1956_230713 {
    static int v, e;
    static long[][] minDis;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        minDis = new long[v+1][v+1];
        for (long[] a : minDis) {
            Arrays.fill(a, Integer.MAX_VALUE);
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            minDis[a][b] = c;
        }

        floydWarshall();

        long answer = Integer.MAX_VALUE;
        // 같은자리로 돌아오는 사이클의 최단거리 구하기
        for (int i = 1; i <= v; i++) {
            answer = Math.min(answer, minDis[i][i]);
        }

        if (answer == Integer.MAX_VALUE) sb.append("-1");
        else sb.append(answer);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    // 플로이드 와샬 알고리즘
    static void floydWarshall() {
        for (int i = 1; i <= v; i++) {
            for (int j = 1; j <= v; j++) {
                for (int k = 1; k <= v; k++) {
                    minDis[i][j] = Math.min(minDis[i][j], minDis[i][k] + minDis[k][j]);
                }
            }
        }
    }
}
