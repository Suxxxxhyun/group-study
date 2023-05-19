package BOJ.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1676_230329 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        System.out.println(Fectorial(N));
    }

    static int Fectorial(int N) {
        int cnt = 0;
        while(N >= 5) {
            cnt += N / 5;
            N /= 5;
        }
        return cnt;
    }
}
