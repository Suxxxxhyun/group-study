package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_6808_230512 {
    static int T;
    static int total, draw, cnt;
    static int[] card;
    static boolean[] visited;
    static ArrayList<Integer> gyu;
    static ArrayList<Integer> in;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            card = new int[19];
            visited = new boolean[9];
            total = draw = cnt = 0;

            gyu = new ArrayList<>();
            in = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                int now = Integer.parseInt(st.nextToken());
                gyu.add(now);
                card[now] = 1;
            }

            for (int j = 1; j < card.length; j++) {
                if (card[j] == 0) in.add(j);
            }


            dfs(0, 0, 0);
            sb.append(String.format("#%d %d %d\n", i, cnt, total - cnt - draw));
        }
        System.out.println(sb);
    }

    static void dfs(int depth, int sg, int si) {
        if (depth == 9) {
            total++;
            if (sg > si) cnt++;
            else if (sg > si) draw++;
            return;
        }

        for (int i = 0; i < 9; i++) {
            if (!visited[i]) {
                visited[i] = true;
                if (gyu.get(depth) > in.get(i)) dfs(depth + 1, sg + gyu.get(depth) + in.get(i), si);
                else dfs(depth + 1, sg, si + gyu.get(depth) + in.get(i));
                visited[i] = false;
            }
        }
    }
}
