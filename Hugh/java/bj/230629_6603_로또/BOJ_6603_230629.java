package BOJ.BackTracking;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_6603_230629 {
    static int[] result;
    static boolean[] visited;
    static int[] arrS;
    static int k;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());

            // 종료 조건
            if (k == 0) break;

            arrS = new int[k];
            for (int i = 0; i < k; i++) {
                arrS[i] = Integer.parseInt(st.nextToken());
            }

            result = new int[6];
            visited = new boolean[k];
            dfs(0,0);

//             오버헤드 발생 가능성
//            System.out.println(sb);

            sb.append("\n"); // sb에 넣어서 bw로 출력하는 형식으로 변경
        }

        bw.write(sb.toString());
        bw.flush();

        bw.close();
        br.close();
    }

    static void dfs(int start, int depth) {
        if (depth == 6) {
            for (int i = 0; i < 6; i++) {
                sb.append(result[i] + " ");
            }
            sb.append("\n");
            return;
        }
        for (int i = start; i < k; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[depth] = arrS[i];
                dfs(i, depth + 1);
                visited[i] = false;
            }
        }
    }
}
