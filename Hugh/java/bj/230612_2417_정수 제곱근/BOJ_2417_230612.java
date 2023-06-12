package BOJ.BinarySearch;

import java.io.*;

public class BOJ_2417_230612 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        long N = Long.parseLong(br.readLine());

        sb.append(bSearch(N));
        bw.write(sb.toString());
        bw.flush();

        bw.close();
        br.close();
    }

    static long bSearch(long n) {
        if (n == 0) return 0;

        long L = 0;
        long R = n;
        long result = 0;

        while (L < R) {
            long mid = (L + R) / 2;
            long val = (long)Math.pow(mid, 2);

            if (n <= val) {
                result = mid;
                R = mid;
            } else {
                L = mid + 1;
            }
        }
        return result;
    }
}
