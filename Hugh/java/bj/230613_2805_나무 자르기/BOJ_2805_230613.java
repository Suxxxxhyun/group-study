package BOJ.BinarySearch;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2805_230613 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] tree = new int[N];
        for (int i = 0; i < N; i++) {
            int key = Integer.parseInt(st.nextToken());
            tree[i] = key;
        }
        Arrays.sort(tree);
        sb.append(UpperBound(tree, M));

        bw.write(sb.toString());
        bw.flush();

        bw.close();
        bw.close();
    }

    static int UpperBound(int[] tree, int M) {
        int L = 0;
        int R = tree[tree.length - 1] + 1;

        while (L < R) {
            int mid = (L + R) / 2;
            long sum = 0;

            for (int height : tree) {
                if (height - mid > 0) {
                    sum += (height - mid);
                }
            }

            if (sum < M) {
                R = mid;
            } else {
                L = mid + 1;
            }
        }
        return L - 1;
    }
}
