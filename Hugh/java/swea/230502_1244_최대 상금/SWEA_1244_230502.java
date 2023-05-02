package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_1244_230502 {
    static int T;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String N = st.nextToken();
            char[] arr = N.toCharArray();
            char[] tmp = N.toCharArray();
            int cnt = Integer.parseInt(st.nextToken());

            // 최대값 만들기
            Arrays.sort(tmp);
            StringBuilder sb1 = new StringBuilder(String.valueOf(tmp));
            String max = sb1.reverse().toString();

            if (arr.length < cnt) {
                cnt = arr.length;
            }

            sb.append(String.format("#%d %s\n", i, dfs(arr, 0, max, cnt)));
        }

        System.out.println(sb);
    }

    static void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    static String dfs (char[] arr, int start, String max, int cnt) {
        if (cnt <= 0) {
            return String.valueOf(arr);
        }

        // 최대값이 되는 경우
        if (String.valueOf(arr).equals(max)) {
            if (cnt % 2 == 0) { return max; }
        }

        int num = 0;
        String numS = "";

        for (int i = start; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                swap(arr, i, j);
                num = Math.max(Integer.parseInt(dfs(arr, i, max, cnt-1)), num);
                numS = num + "";
                swap(arr, j, i);
            }
        }
        return numS;
    }

}
