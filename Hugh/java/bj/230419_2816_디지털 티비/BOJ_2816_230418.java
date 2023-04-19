package BOJ.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2816_230418 {
    static int N;
    static String[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        arr = new String[N];

        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        for (int i = 0; i < N; i++) {
            if (arr[i].equals("KBS1")) {
                String tmp = "";
                for (int j = i; j > 0; j--) {
                    sb.append(4);
                    tmp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = tmp;
                }
                break;
            } else {
                sb.append(1);
            }
        }

        if (arr[1].equals("KBS2")) {
            System.exit(0);
        }

        for (int i = 0; i < N; i++) {
            if (arr[i].equals("KBS2")) {
                String tmp = "";
                for (int j = i; j > 1; j--) {
                    sb.append(4);
                    tmp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = tmp;
                }
                break;
            } else {
                sb.append(1);
            }
        }

        System.out.println(sb);

    }
}
