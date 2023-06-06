package BOJ.BinarySearch;

import java.io.*;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_1920_230606 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        Set<Integer> set = new HashSet<>();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        while (M-- > 0) {
            int x = Integer.parseInt(st.nextToken());
            sb.append(set.contains(x) ? 1 : 0).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();

        bw.close();
        br.close();
    }
}
