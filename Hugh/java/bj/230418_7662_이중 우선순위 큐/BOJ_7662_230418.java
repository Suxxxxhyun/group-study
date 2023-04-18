package BOJ.Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class BOJ_7662_230418 {
    static int T;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int k = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> map = new TreeMap<>();
            while (k-- > 0) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String commend = st.nextToken();
                int n = Integer.parseInt(st.nextToken());
                switch (commend) {
                    case "D":
                        if (map.size() == 0) {
                            continue;
                        }
                        if (n == 1) {
                            if (map.put(map.lastKey(), map.get(map.lastKey()) - 1) == 1) {
                                map.remove(map.lastKey());
                            }
                        } else if (n == -1) {
                            if (map.put(map.firstKey(), map.get(map.firstKey()) - 1) == 1) {
                                map.remove(map.firstKey());
                            }
                        }
                        break;
                    case "I":
                        map.put(n, map.getOrDefault(n, 0) + 1);
                        break;
                }
            }
            if (map.size() == 0) {
                sb.append("EMPTY").append("\n");
            } else {
                sb.append(map.lastKey() + " " + map.firstKey()).append("\n");
            }

        }

        System.out.println(sb);
    }

}
