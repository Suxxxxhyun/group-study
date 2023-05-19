package SWEA.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class SWEA_1983_230427 {
    static int T;
    static String[] score = {"A+","A0","A-","B+","B0","B-","C+","C0","C-","D0"};
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int search = Integer.parseInt(st.nextToken());

            Integer[] student = new Integer[num];
            for (int j = 0; j < num; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                student[j] = ((a * 35) + (b * 45) + (c * 20));
            }
            int result = student[search - 1];
            Arrays.sort(student, Collections.reverseOrder());

            int rank = Arrays.asList(student).indexOf(result);
            sb.append(String.format("#%d %s\n", i, score[10 * rank / num]));
        }

        System.out.println(sb);
    }
}
