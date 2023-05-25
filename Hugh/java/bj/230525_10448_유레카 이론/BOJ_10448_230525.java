package BOJ.BruteForce;

import java.io.*;
import java.util.ArrayList;

public class BOJ_10448_230525 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        ArrayList<Integer> list = new ArrayList<>();
        int cnt = 1;
        for (int i = 1; i <= 1000; i += cnt) {
            list.add(i);
            cnt++;
        }

        int N = Integer.parseInt(br.readLine());
        for (int t = 0; t < N; t++) {
            int K = Integer.parseInt(br.readLine());

            int flag = 0;
            for (int i = 0; i < list.size(); i++) {
                for (int j = 0; j < list.size(); j++) {
                    for (int k = 0; k < list.size(); k++) {
                        if (list.get(i) + list.get(j) + list.get(k) == K) {
                            flag = 1;
                            break;
                        }
                    }
                }
            }
            sb.append(flag).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
