package BOJ.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10158_230522 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        int t = Integer.parseInt(br.readLine());

        int cnt1 = ((t + p) % (2 * W));
        int cnt2 = ((t + q) % (2 * H));

        if (cnt1 > W) cnt1 = ((2 * W) - cnt1);
        if (cnt2 > H) cnt2 = ((2 * H) - cnt2);

        sb.append(String.format("%d %d\n", cnt1, cnt2));
        System.out.println(sb);
    }
}
