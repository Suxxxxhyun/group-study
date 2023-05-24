package BOJ.TwoPointer;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_3273_230524 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        boolean[] exist = new boolean[1000001];
        for (int i = 0; i < N; i++) {
            exist[arr[i]] = true;
        }

        int x = Integer.parseInt(br.readLine());
        int cnt = 0;
        for (int i = 1; i <= (x - 1) / 2; i++) {
            if (i <= 1000000 && x - i <= 1000000) {
                cnt += (exist[i] && exist[x - i]) ? 1 : 0;
            }
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
    }
}
