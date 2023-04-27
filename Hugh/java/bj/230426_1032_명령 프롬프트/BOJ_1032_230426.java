package BOJ.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1032_230426 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        String[] arr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        for (int i = 0; i < arr[0].length(); i++) {
            char c = arr[0].charAt(i);

            boolean check = true;
            for (int j = 1; j < N; j++) {
               if (c != arr[j].charAt(i)) {
                   check = false;
                   break;
               }
            }

            if (check == true) {
                sb.append(c);
            } else {
                sb.append("?");
            }
        }

        System.out.println(sb);
    }
}
