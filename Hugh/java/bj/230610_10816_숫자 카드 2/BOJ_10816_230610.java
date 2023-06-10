package BOJ.BinarySearch;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10816_230610 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N  = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int M  = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            int cnt = upperBound(arr, num) - lowerBound(arr, num);

            sb.append(cnt + " ");
        }

        bw.write(sb.toString());
        bw.flush();

        bw.close();
        br.close();
    }

    private static int lowerBound(int[] arr, int num) {
        int L = 0;
        int R = arr.length;

        while (L < R) {
            int mid = L + (R - L) / 2;

            if (num <= arr[mid]) {
                R = mid;
            } else {
                L = mid + 1;
            }
        }
        return L;
    }

    private static int upperBound(int[] arr, int num) {
        int L = 0;
        int R = arr.length;

        while (L < R) {
            int mid = L + (R - L) / 2;

            if (num < arr[mid]) {
                R = mid;
            } else {
                L = mid + 1;
            }
        }
        return L;
    }
}
