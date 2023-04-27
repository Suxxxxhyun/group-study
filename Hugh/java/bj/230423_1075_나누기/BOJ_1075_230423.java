package BOJ.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1075_230423 {
    static int N,F;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        F = Integer.parseInt(br.readLine());

        int temp = (N / 100) * 100;

        while (true) {

            if (temp % F == 0) {
                int result = temp % 100;
                if (result < 10) {
                    System.out.println("0" + result);
                    break;
                } else {
                    System.out.println(result);
                    break;
                }
            }
            temp++;
        }

    }
}
