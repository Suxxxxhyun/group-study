package BOJ.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
    09:10~09:35

    백트래킹 완전탐색
    중복 숫자 들어갈 수 없음

 */
public class BOJ_2529_230720 {
    static int k;
    static String[] arr;
    static ArrayList<String> list = new ArrayList<>();
    static boolean[] visited = new boolean[10]; // 0~9 방문체크
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder();

        k = Integer.parseInt(br.readLine());
        arr = new String[k];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            arr[i] = st.nextToken();
        }


        dfs("",0);

        sb.append(list.get(list.size()-1)).append("\n");
        sb.append(list.get(0));

        System.out.println(sb);
    }

    static void dfs(String str, int depth) {
        if (depth == k+1) {
            list.add(str);
            return;
        }

        for (int i = 0; i <= 9; i++) { //부등호 앞뒤에 들어가는 숫자 0~9
            if (depth == 0 || !visited[i] && check(str.charAt(str.length() - 1) - '0', i, arr[depth-1])) {
                visited[i] = true;
                dfs(str + i, depth + 1);
                visited[i] = false;
            }
        }
    }

    static boolean check(int num1, int num2, String sign) {
        if (sign.equals("<")) {
            return num1 < num2;
        }
        return num1 > num2;
    }
}
