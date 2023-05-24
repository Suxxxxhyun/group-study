package BOJ.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10431_230524 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            int[] arr = new int[20];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            for (int j = 0; j < 20; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            int cnt = 0;
            while (true) {
                boolean flag = false;

                for (int j = 19; j > 0; j--) {
                    if (arr[j] < arr[j - 1]) {
                        int tem = arr[j - 1];
                        arr[j - 1] = arr[j];
                        arr[j] = tem;
                        flag = true;
                        cnt++;
                    }
                }

                if (flag == false) {
                    break;
                }
            }
            sb.append(String.format("%d %d\n", i, cnt));
        }
        System.out.println(sb);
    }
}
