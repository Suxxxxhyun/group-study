package Programmers;

public class PG_64062_230310 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{2, 4, 5, 3, 2, 1, 4, 2, 5, 1}, 3));
    }

    public static int solution(int[] stones, int k) {
        int left = 1;
        int right = 200000000;
        while (left <= right) {
            int cnt = 0;
            int mid = (left + right) / 2;
            // mid 값이 k가 될 경우 불가능한 카운트 수
            for (int stone: stones) {
                if (stone - mid <= 0) {
                    cnt += 1;
                } else {
                    cnt = 0;
                }
                if (cnt >= k) {
                    break;
                }
            }
            if (cnt >= k) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
