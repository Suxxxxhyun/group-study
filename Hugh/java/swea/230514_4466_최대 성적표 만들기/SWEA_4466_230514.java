package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class SWEA_4466_230514 {
    static int T, N, K;
    static int maxScore;
    static Integer[] score;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            score = new Integer[N];

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                score[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(score, Comparator.reverseOrder());

            maxScore = 0;
            for (int j = 0; j < K ; j++) {
                maxScore += score[j];
            }
            sb.append(String.format("#%d %d\n", i, maxScore));
        }
        System.out.println(sb);
    }
}
