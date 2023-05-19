package BOJ.TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_3273_230411 {
    static int N,X;
    static int[] arr;
    static int cnt = 0;
    static int A;
    static int B;
    static int sum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        X = Integer.parseInt(br.readLine());

        A = 0;
        B = N - 1;

        TwoPointer(A, B);
        System.out.println(cnt);
    }

    static void TwoPointer(int A, int B) {
        while (A < B) {
            sum = arr[A] + arr[B];

            if (sum == X)
                cnt++;
            if (sum <= X)
                A++;
            else
                B--;

        }
    }
}

