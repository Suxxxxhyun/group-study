package BOJ.DP;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_11660_230602 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] prefixArr = new int[N + 1][N + 1];

        // 더해주고 중복된 값 빼주면서
        for(int i=1; i<N+1; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<N+1; j++) {
                prefixArr[i][j] = prefixArr[i][j - 1] + prefixArr[i - 1][j] - prefixArr[i - 1][j - 1] + Integer.parseInt(st.nextToken());
            }
        }

        // 중복으로 더해지는 값 제거
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());

            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            sb.append(prefixArr[x2][y2] - prefixArr[x1 - 1][y2] - prefixArr[x2][y1 - 1] + prefixArr[x1 - 1][y1 - 1]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();

        bw.close();
        br.close();
    }
}
