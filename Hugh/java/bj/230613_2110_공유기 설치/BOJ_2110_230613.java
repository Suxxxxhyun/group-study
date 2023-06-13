package BOJ.BinarySearch;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2110_230613 {
    static int[] house;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        house = new int[N];
        for (int i = 0; i < N; i++) {
            house[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(house);
        sb.append(UpperBound(N, C));

        bw.write(sb.toString());
        bw.flush();

        bw.close();
        br.close();
    }

    static int UpperBound(int N, int C) {
        int L = 1;
        int R = house[N - 1] - house[0] + 1;

        while (L < R) {
            int mid = (L + R) / 2;
            if (canInstall(mid) < C) {
                R = mid;
            } else {
                L = mid + 1;
            }
        }

        return L - 1;
    }

    static int canInstall(long distance) {
        int cnt = 1;
        int lastLocation = house[0];

        for (int i = 1; i < house.length; i++) {
            int locate = house[i];

            if (locate - lastLocation >= distance) {
                cnt++;
                lastLocation = locate;
            }
        }
        return cnt;
    }

}
