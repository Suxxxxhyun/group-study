package BOJ.BinarySearch;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_14425_230606 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] arr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }
        Arrays.sort(arr);

        int cnt = 0;
        while (M-- > 0) {
            String str = br.readLine();
            cnt += BinarySearch(arr, str);
        }

        bw.write(String.valueOf(cnt));
        bw.flush();

        bw.close();
        br.close();
    }

    static int BinarySearch(String[] arr, String str) {
        int L = 0;
        int R = arr.length - 1;

        while (L <= R) {
            int mid = (L + R) / 2;
            if (arr[mid].equals(str)) {
                return 1;
            } else if (arr[mid].compareTo(str) > 0) {
                R = mid - 1;
            } else if (arr[mid].compareTo(str) < 0) {
                L = mid + 1;
            }
        }

        return 0;
    }
}
