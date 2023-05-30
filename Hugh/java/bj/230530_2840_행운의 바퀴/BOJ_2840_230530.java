package BOJ.Implementation;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2840_230530 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean[] alphabet = new boolean[26];
        char[] roulette = new char[N];
        Arrays.fill(roulette, '?');

        // 마지막 입력부터 찾아보기
        char[] inputAlphabet = new char[K];
        int[] inputStep = new int[K];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            inputStep[i] = Integer.parseInt(st.nextToken());
            inputAlphabet[i] = st.nextToken().charAt(0);
        }


        int idx = 0;
        roulette[idx] = inputAlphabet[K - 1];
        alphabet[inputAlphabet[K - 1] - 'A'] = true;

        for (int i = K - 2; i >= 0; i--) {
            int step = inputStep[i + 1];
            char beforeAlphabet = inputAlphabet[i];
            idx = (idx + step) % N;

            if (roulette[idx] == beforeAlphabet) continue;

            if (roulette[idx] == '?' && !alphabet[beforeAlphabet - 'A']) {
                roulette[idx] = beforeAlphabet;
                alphabet[beforeAlphabet - 'A'] = true;
            } else {
                System.out.println('!');
                return;
            }
        }

        for (int i = 0; i < N; i++) {
            sb.append(roulette[i]);
        }
        bw.write(sb.toString());
        bw.flush();

        bw.close();
        br.close();
    }
}
