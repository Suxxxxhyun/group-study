package BOJ.BinarySearch;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1920_230613 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int key = Integer.parseInt(st.nextToken());
            sb.append(bSearch(arr, key)).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();

        bw.close();
        br.close();
    }

    static int bSearch(int[] arr, int key) {
        int L = 0;
        int R = arr.length;

        while (L < R) {
            int mid = (L + R) / 2;
            if (arr[mid] == key) {
                return 1;
            } else if (arr[mid] > key) {
                R = mid;
            } else if (arr[mid] < key) {
                L = mid + 1;
            }
        }
        return 0;
    }
}
