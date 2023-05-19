package BOJ.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_7795_230412 {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int[] arr1 = new int[a];
            int[] arr2 = new int[b];

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < a; j++) {
                arr1[j] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < b; j++) {
                arr2[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr1);
            Arrays.sort(arr2);

            int cnt = 0;
            for (int j = 0; j < a; j++) {
                cnt += BinarySearch(arr2, 0, arr2.length - 1, arr1[j]);
            }
            sb.append(cnt).append("\n");
        }

        System.out.println(sb);
    }

    static int BinarySearch(int[] arr2, int L, int R, int target) {

        while (L <= R) {
            int mid = (L + R) / 2;
            if(arr2[mid] < target) {
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }

        return L;
    }

}
