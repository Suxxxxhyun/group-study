package BOJ.BinarySearch;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BOJ_2295_230606 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                list.add(arr[i] + arr[j]);
            }
        }
        Arrays.sort(arr);
        Collections.sort(list);

        int max = Integer.MIN_VALUE;
        for (int i = N - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (BinarySearch(list, arr[i] - arr[j])) {
                    max = Math.max(max, arr[i]);
                }
            }
        }

        bw.write(String.valueOf(max));
        bw.flush();

        bw.close();
        br.close();
    }

    static boolean BinarySearch(List<Integer> list, int x) {
        int L = 0;
        int R = list.size() - 1;
        while (L <= R) {
            int mid = (L + R) / 2;
            if (list.get(mid) == x) {
                return true;
            } else if (list.get(mid) > x) {
                R = mid - 1;
            } else if (list.get(mid) < x) {
                L = mid + 1;
            }
        }
        return false;
    }
}
