package BOJ.TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
    10:35~
    연속되는 소수로 n 구하기
    * 투포인터
 */
public class BOJ_1644_230801 {
    static ArrayList<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());


        for (int i = 1; i <= n; i++) {
            if (makePrime(i)) {
                list.add(i);
            }
        }

        int L = 0, R = 0, cnt = 0, sum = 0;

        while (true) {
            if (sum == n) {
                cnt++;
                sum -= list.get(L);
                L++;
            } else if (sum > n) {
                sum -= list.get(L);
                L++;
            } else if (R == list.size()) {
                break;
            } else {
                sum += list.get(R);
                R++;
            }
        }

        System.out.println(cnt);
    }

    static boolean makePrime(int num) {
        if (num < 2) return false; // 2보다 작으면 소수 아님
        if (num == 2) return true; // 2는 소수


        for (int i = 2; i <= Math.sqrt(num); i++) { // 루트값으로 소수 구하기
            if (num % i == 0) return false; // 소수가 아닐경우
        }

        // 모두 통과하면 소수임
        return true;
    }
}
