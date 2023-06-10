package BOJ.BinarySearch;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2470_230606 {
    static int arr1 = 0, arr2 = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int min = Integer.MAX_VALUE;
        BinarySearch(arr, min);

        sb.append(arr1 + " " + arr2);

        bw.write(sb.toString());
        bw.flush();

        bw.close();
        br.close();
    }

    static void BinarySearch(int[] arr, int min) {

        int L = 0;
        int R = arr.length - 1;
        int sum;
        int temp;

        while (L < R) {
            sum = arr[L] + arr[R];
            temp = Math.abs(sum);
            if (temp < min) {
                min = temp;
                arr1 = arr[L];
                arr2 = arr[R];
            }
            if (sum > 0) R--;
            else L++;
        }
    }
}
