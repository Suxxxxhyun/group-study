package BOJ.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1759_230413 {
    static int L,C;
    static String[] arr;
    static String[] pass;

    static StringBuilder sb = new StringBuilder();
    static String sum = "";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new String[C];
        pass = new String[L];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            arr[i] = st.nextToken();
        }

        Arrays.sort(arr);

        dfs(0, 0);
        System.out.println(sb);
    }

    static void dfs(int start, int depth) {
        if (depth == L) {
            if(check()) {
                for (String val : pass) {
                    sb.append(val);
                }
                sb.append("\n");
            }
            return;
        }

        for (int i = start; i < C; i++) {

            pass[depth] = arr[i];
            dfs(i + 1, depth + 1);

        }
    }

    static boolean check() {
        boolean Frag = false;

        int vo = 0;
        int co = 0;
        for (String val : pass) {
            if (val.equals("a") || val.equals("e") || val.equals("i") || val.equals("o") || val.equals("u")) {
                vo++;
            } else {
                co++;
            }
        }
        if (vo >= 1 && co >= 2) {
            Frag = true;
        }

        return Frag;
    }
}
