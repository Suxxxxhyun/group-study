package SWEA.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SWEA_1204_230430 {
    static int T;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[1000];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 1000; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            TreeMap<Integer, Integer> map = new TreeMap<>();
            for (int key : arr) {
                map.put(key, map.getOrDefault(key, 0) + 1);
            }

            int findNum = 0;
            Integer maxValue = Collections.max(map.values());
            for (int key : map.keySet()) {
                if (map.get(key).equals(maxValue)) {
                    findNum = key;
                }
            }
            sb.append(String.format("#%d %d\n", i, findNum));
        }
        System.out.println(sb);
    }
}
