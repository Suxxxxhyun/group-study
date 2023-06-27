package BOJ.Greedy;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ_20915_230627 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String N = br.readLine();
            ArrayList<Long> nums = new ArrayList<>();

            for (int i = 0; i < N.length(); i++) {
                if (N.charAt(i) == '6') nums.add(9L);
                else nums.add((long)(N.charAt(i) - '0'));
            }

            int zeros = Collections.frequency(nums, 0);

            Collections.sort(nums, Collections.reverseOrder());

            for (int i = 0; i < zeros; i++) {
                nums.remove(nums.size() - 1);
            }

            if (nums.isEmpty()) {
                System.out.println(0);
                continue;
            }

            long a = nums.get(0);
            long b = 0;

            for (int i = 1; i < nums.size(); i++) {
                if (a > b) b = b * 10 + nums.get(i);
                else a = a * 10 + nums.get(i);
            }

            /*
                321
                31 * 2 = 62
                21 * 3 = 63

             */

            for (int i = 0; i < zeros; i++) {
                a *= 10;
            }
            sb.append(a * b).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();

        bw.close();
        br.close();
    }
}
