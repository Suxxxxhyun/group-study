package BOJ.BruteForce;

import java.io.*;
import java.util.ArrayList;

public class BOJ_11068_230525 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());

            int flag = 0;
            for (int j = 2; j <= 64; j++) {
                int num = N;
                ArrayList<Integer> list = new ArrayList<>();

                while (num > 0) {
                    list.add(num % j);
                    num /= j;
                }

                if (isPalindrome(list)) {
                    flag = 1;
                    break;
                }
            }
            sb.append(flag).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }

    static boolean isPalindrome(ArrayList<Integer> list) {
        for (int k = 0; k < list.size() / 2; k++) {
            if (list.get(k) != list.get(list.size() - 1 - k)) {
                return false;
            }
        }
        return true;
    }
}
