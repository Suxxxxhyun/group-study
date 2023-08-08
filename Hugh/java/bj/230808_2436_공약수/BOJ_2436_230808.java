package BOJ.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    17:00~18:17

    *정수론*
    (결국 블로그 참조 : 크기부분에서 반례가 있었던것 같다, 입력값으로 비교하여 해결.)

    유클리드 호제법 - GCD 를 구하는 알고리즘

    GCD(최대공약수) LCM(최소공배수) 구하기
 */
public class BOJ_2436_230808 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long gcd = Integer.parseInt(st.nextToken()); // 최대공약수
        long lcm = Integer.parseInt(st.nextToken()); // 최소공배수

        long num = gcd * lcm;

        long a = gcd; // 자연수 a
        long b = lcm; // 자연수 b

        for (long i = gcd * 2; i * i <= num; i += gcd) {
            if (num % i == 0) {

                long preA = i;
                long preB = num/i;

                if (GCD(preA, preB) == gcd) { // 일치한다면 작은 녀석으로 갱신
                    if (a + b > preA + preB) {
                        a = preA;
                        b = preB;
                    }
                }
            }
        }
        System.out.println(a + " " + b);
    }

    // 최대공약수 구하기
    static long GCD(long a, long b) {
        while (a % b != 0) {
            long tmp = a % b;
            a = b;
            b = tmp;
        }
        return b;
    }
}
