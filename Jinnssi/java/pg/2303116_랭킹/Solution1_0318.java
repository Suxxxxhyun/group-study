class Solution1_0318 {
    public static int solution(int n) {
        int answer = 0;
        while (n > 0) {
            answer += n % 10;
            n /= 10;
        }
        if (answer >= 10) {
            return solution(answer);
        }
        return answer;
    }
}