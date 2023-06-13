package BOJ.BinarySearch;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10816_230613 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] arr1 = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr1);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            sb.append(UpperBound(arr1, num) - LowerBound(arr1, num) + " ");
        }

        bw.write(sb.toString());
        bw.flush();

        bw.close();
        br.close();
    }

    static int UpperBound(int[] arr1, int num) {
        int L = 0;
        int R = arr1.length;

        while (L < R) {
            int mid = (L + R) / 2;

            if (num < arr1[mid]) {
                R = mid;
            } else {
                L = mid + 1;
            }
        }

        return L;
    }

    static int LowerBound(int[] arr1, int num) {
        int L = 0;
        int R = arr1.length;

        while (L < R) {
            int mid = (L + R) / 2;

            if (num <= arr1[mid]) {
                R = mid;
            } else {
                L = mid + 1;
            }
        }

        return L;
    }
}
