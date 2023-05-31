package BOJ.Implementation;

import java.io.*;
import java.util.*;

public class BOJ_7785_230531 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        TreeMap<String, String> map = new TreeMap<>(Comparator.reverseOrder());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String inOut = st.nextToken();

            map.put(name, inOut);
        }

        // 새로운 map.forEach 의 접근 방식
        map.forEach((key, value) -> {
            if (value.equals("enter")) {
                sb.append(key).append("\n");
            }
        });

        bw.write(sb.toString());
        bw.flush();

        bw.close();
        br.close();
    }
}
