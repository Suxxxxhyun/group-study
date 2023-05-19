package SWEA.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1959_230428 {
    static int T;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int[] arrA = new int[a];
            int[] arrB = new int[b];

            // A 채우기
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < a; j++) {
                arrA[j] = Integer.parseInt(st.nextToken());
            }

            // B 채우기
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < b; j++) {
                arrB[j] = Integer.parseInt(st.nextToken());
            }

            // B가 같거나 클경우
            if (arrA.length <= arrB.length) {
                int startA = 0;
                int startB = 0;
                int endB = arrA.length;
                int max = Integer.MIN_VALUE;

                while (endB <= arrB.length) {
                    int sum = 0;
                    for (int j = startB; j < endB; j++) {
                        sum += (arrA[startA] * arrB[j]);
                        startA++;
                    }
                    max = Math.max(max, sum);
                    startA = 0;
                    startB++;
                    endB++;

                }
                sb.append(String.format("#%d %d\n", i, max));
            }

            // A가 클경우
            if (arrA.length > arrB.length) {
                int startB = 0;

                int startA = 0;
                int endA = arrB.length;
                int max = Integer.MIN_VALUE;

                while (endA <= arrA.length) {
                    int sum = 0;
                    for (int j = startA; j < endA; j++) {
                        sum += (arrB[startB] * arrA[j]);
                        startB++;
                    }
                    max = Math.max(max, sum);
                    startB = 0;
                    startA++;
                    endA++;

                }
                sb.append(String.format("#%d %d\n", i, max));
            }
        }
        System.out.println(sb);
    }
}

