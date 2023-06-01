package BOJ.Hashing;

import java.io.*;
import java.util.TreeMap;

public class BOJ_1302_230601 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        TreeMap<String, Integer> map = new TreeMap<>();
        while (N-- > 0) {
            String title = br.readLine();
            map.put(title, map.getOrDefault(title, 1) + 1);
        }

        int[] max = {Integer.MIN_VALUE};
        map.forEach((key, value) -> {
            if (max[0] < value) {
                max[0] = value;
            }
        });

        for (String key : map.keySet()) {
            if (map.get(key).equals(max[0])) {
                sb.append(key);
                break;
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
