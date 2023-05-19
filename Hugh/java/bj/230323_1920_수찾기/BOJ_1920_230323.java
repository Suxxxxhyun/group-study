package BOJ.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1920_230323 {
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
            if(binarySearch(Integer.parseInt(st.nextToken())) >= 0) {
                sb.append(1).append("\n");
            } else {
                sb.append(0).append("\n");
            }
        }
        System.out.println(sb);
    }

    static int binarySearch(int key) {
        int L = 0;
        int R = arr_N.length - 1;

        while(L <= R) {
            int mid = (L + R) / 2;

            if(key > arr_N[mid]) {
                L = mid + 1;
            } else if(key < arr_N[mid]) {
                R = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
