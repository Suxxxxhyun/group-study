package BOJ.Greedy;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_16953_230620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int cnt = 1;
        while (a != b) {
            if (b < a) {
                cnt = -1;
                break;
            }

            if (b % 10 == 1) b /= 10;
            else if (b % 2 == 0) b /= 2;
            else {
                cnt = -1;
                break;
            }
            cnt++;
        }

        bw.write(String.valueOf(cnt));
        bw.flush();

        bw.close();
        bw.close();
    }
}
