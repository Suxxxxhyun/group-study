package SWEA.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA_1961_230427 {
    static int T;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[n][n];
            ArrayList<String> arr90 = new ArrayList<>();
            ArrayList<String> arr180 = new ArrayList<>();
            ArrayList<String> arr270 = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 0; k < n; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            // 90도 회전
            for (int j = 0; j < n; j++) {
                String str = "";
                for (int k = n - 1; k >= 0; k--) {
                    str += arr[k][j];
                }
                arr90.add(str);
            }

            // 180도 회전
            for (int j = n - 1; j >= 0; j--) {
                String str = "";
                for (int k = n - 1; k >= 0; k--) {
                    str += arr[j][k];
                }
                arr180.add(str);
            }

            // 270도 회전
            for (int j = n - 1; j >= 0; j--) {
                String str = "";
                for (int k = 0; k < n; k++) {
                    str += arr[k][j];
                }
                arr270.add(str);
            }

            sb.append("#" + i + "\n");
            for (int k = 0; k < n; k++) {
                sb.append(String.format("%s %s %s\n", arr90.get(k), arr180.get(k), arr270.get(k)));
            }
        }
        System.out.println(sb);
    }
}
