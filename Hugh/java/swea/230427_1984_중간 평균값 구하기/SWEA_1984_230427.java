package SWEA.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_1984_230427 {
    static int T;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            int[] arr = new int[10];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            arr[0] = 0;
            arr[9] = 0;

            sb.append("#" + i + " " + Math.round(average(arr)) + "\n");
        }

        System.out.println(sb);
    }

    static double average(int[] arr) {
        double sum = 0;
        for (int i = 1; i <= 8; i++) {
            sum += arr[i];
        }

        return sum / 8;
    }
}
