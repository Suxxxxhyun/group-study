package BOJ.Math;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
    09:10~(킵)

    *정수론*

    1 <= A <= B <= 1000조

    1000조를 다 돌면 당연히 시간초과
    홀수는 어차피 1
    짝수만 구한다?

    어떻게 최적화 할 수 있을까..

    약수 구하기로 접근 X
    2로 계속해서 나누기

    2^0~
    1로 나누었을 때의 값으로 시작
    2의 배수로 나눈 값 더해가면 정답 나옴

    1차 시도 - 시간 초과
    수많은 시도 - 100
 */
public class BOJ_1407_230808 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        System.out.println(cals(b) - cals(a-1));
    }

    static long cals(long num) {
        if (num == 0) return 0;
        else if (num == 1) return 1;

        long cnt = num;
        for (long i = 2; i <= num; i*=2) {
            cnt += (num / i) * (i / 2);
        }
        return cnt;
    }
}
