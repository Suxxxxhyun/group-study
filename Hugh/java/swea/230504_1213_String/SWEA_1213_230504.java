package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1213_230504 {
    static int N;
    static int cnt = 0;
    static String searchStr, mainStr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= 10; i++) {
            N = Integer.parseInt(br.readLine());
            searchStr = br.readLine();
            mainStr = br.readLine();
            Search();

            sb.append(String.format("#%d %d\n", i, cnt));
            cnt = 0;
        }
        System.out.println(sb);
    }

    static void Search() {
        while (mainStr.contains(searchStr)) {
            mainStr = mainStr.replaceFirst(searchStr, "");
            cnt++;
        }
    }
}
