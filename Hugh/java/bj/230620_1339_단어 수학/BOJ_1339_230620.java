package BOJ.Greedy;

import java.io.*;
import java.util.Arrays;

public class BOJ_1339_230620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] alpha = new int[26];

        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            String str = br.readLine();
            int temp = (int)Math.pow(10, str.length() - 1);
            for (int i = 0; i < str.length(); i++) {
                alpha[str.charAt(i) - 'A'] += temp;
                temp /= 10;
            }
        }
        Arrays.sort(alpha);

        int idx = 9;
        int sum = 0;
        for (int i = alpha.length - 1; i >= 0; i--) {
            if (alpha[i] == 0) continue;

            sum += (alpha[i] * idx);
            idx--;
        }

        bw.write(String.valueOf(sum));
        bw.flush();

        bw.close();
        br.close();
    }
}
