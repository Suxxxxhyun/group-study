/*
2023.06.14
time: 13:48 ~ 15:17 (fail) -> 비율로 대각선에 포함되는 정사각형 개수 찾으려고 함

[대각선에 포함되는 정사각형의 개수 규칙 찾기]
-> 개수: w + h - gcd(w, h)

[gcd 구하기]
1. gcd 유클리드 호제법 구현
자연수 n, m이고 (n > m), n을 m으로 나눈 나머지가 r일 때,
gcd(n, m) == gcd(m, r) 임을 이용.

2. BigInteger의 gcd 메소드

*/
import java.math.*;

class Solution {
    // 첫풀이: Math.ceil(w/h) -> 반례: w=3, h=8
    public long solution(int w, int h) {
        // long answer = solve1(w, h);
        long answer = solve2(w, h);
        return answer;
    }
    
    private long solve2(int w, int h) {
        BigInteger W = BigInteger.valueOf(w);
        BigInteger H = BigInteger.valueOf(h);
        BigInteger tempGcd = W.gcd(H);
        long gcd = tempGcd.longValue();
        return (long) w * (long) h - ((long) w + (long) h - gcd);
    }
    
    private long solve1(int w, int h) {
        long largeNum = (long) Math.max(w, h);
        long smallNum = (long) Math.min(w, h);
        long all = largeNum * smallNum;
        long diagonal = (long) w + (long) h - gcd(largeNum, smallNum);
        long answer = all - diagonal;
        return answer;
    }
    
    private long gcd(long num1, long num2) {
        if(num2 == 0) {
            return num1;
        }
        return gcd(num2, num1%num2);
    }
}
