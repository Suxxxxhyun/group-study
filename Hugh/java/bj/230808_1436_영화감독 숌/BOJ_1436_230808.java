package BOJ.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    10:24~10:29

    *BruteForce*
    (탐욕적으로 탐색)

    적어도 3개 이상의 6
 */
public class BOJ_1436_230808 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int cnt = 1;
        int num = 666;
        while (cnt != n) {
            num++;
            if (String.valueOf(num).contains("666")) {
                cnt++;
            }
        }

        System.out.println(num);
    }
}
