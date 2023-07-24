package Programmers.Lv3;

import java.util.*;

/*
    09:00~
    경우의 수 n!

    n! / n = 요소의 개수
    k / 요소의 개수 = 필요한 숫자
    123 213 312
    132 231 321

    12
    21

    2
*/
public class PG_12936_230724 {
    public int[] solution(int n, long k) {
        ArrayList<Integer> list = new ArrayList<>();

        long facto = 1; // 팩토리얼 구하기
        for (int i = 1; i <= n; i++) {
            list.add(i); // 1~n 으로 초기화
            facto *= i;
        }

        k -= 1;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            facto /= n - i; // facto = 2 1 0
            result[i] = list.remove((int) (k / facto)); // 2 0 0
            k %= facto; // k = 4 0
        }

        return result;
    }
}
