package BOJ.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1267_230425 {
    static int T;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        arr = new int[T];

        int totalY = 0;
        int totalM = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < T; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

            if (arr[i] < 30) {
                totalY += 10;
            } else {
                totalY += 10 * ((arr[i] / 30) + 1);
            }

            if (arr[i] < 60) {
                totalM += 15;
            } else {
                totalM += 15 * ((arr[i] / 60) + 1);
            }
        }

        if (totalY < totalM) {
            System.out.println("Y " + totalY);
        } else if (totalY > totalM) {
            System.out.println("M " + totalM);
        } else {
            System.out.println("Y M " + totalM);
        }

    }
}
