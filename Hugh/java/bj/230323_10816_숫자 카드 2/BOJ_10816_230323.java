package BOJ.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10816_230323 {
    static int[] arr_N;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        arr_N = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr_N[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr_N);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            int key = Integer.parseInt(st.nextToken());
            sb.append(upperBound(arr_N, key) - lowerBound(arr_N, key)).append(" ");
        }

        System.out.println(sb);

    }

    static int lowerBound(int[] arr, int key) {
        int L = 0;
        int R = arr.length;

        while(L < R) {
            int mid = (L + R) / 2;

            if(key <= arr[mid]) {
                R = mid;
            } else {
                L = mid + 1;
            }
        }

        return L;
    }

    static int upperBound(int[] arr, int key) {
        int L = 0;
        int R = arr.length;

        while(L < R) {
            int mid = (L + R) / 2;

            if(key < arr[mid]) {
                R = mid;
            } else {
                L = mid + 1;
            }
        }

        return L;
    }
}
