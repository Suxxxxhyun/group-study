package BOJ.BruteForce;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1034_230627 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] table = new int[N][M];
        String[] temp = new String[N];

        for (int i = 0; i < N; i++) {
            temp[i] = br.readLine();
            for (int j = 0; j < M; j++) {
                table[i][j] = Integer.parseInt(temp[i].charAt(j) + "");
            }
        }

        int K = Integer.parseInt(br.readLine());
        boolean[] visited = new boolean[N];
        int max = 0;

        for (int i = 0; i < N; i++) {
            int cnt = 0;
            for (int j = 0; j < M; j++) {
                if (table[i][j] == 0) {
                    cnt++;
                }
            }

            if ((cnt % 2 == K % 2) && cnt <= K) { // 조건에 맞는 값만 탐색
                visited[i] = true;
            }
        }

        for (int i = 0; i < N; i++) {
            if (visited[i]) {
                int cnt = 0;
                for (int j = 0; j < N; j++) {
                    if (temp[i].equals(temp[j])) {
                        cnt++;
                    }
                }
                if (max < cnt) {
                    max = cnt;
                }
            }
        }
        sb.append(max);
        bw.write(sb.toString());
        bw.flush();

        bw.close();
        br.close();
    }
}
