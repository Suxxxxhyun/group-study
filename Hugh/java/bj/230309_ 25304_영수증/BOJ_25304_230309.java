package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_25304_230309 {
    static int x, n;
    static int sum = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        x = Integer.parseInt(br.readLine());
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sum += (a*b);
        }

        if (sum == x)
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
