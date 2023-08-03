/* 2023.08.03 (10:23 ~ 10:53) solve

입력:
 1. 문자열 s의 길이: 1 ~ 2,500
 2. 문자열 s는 소문자로만 구성
 3. 가능 시간복잡도: O(S^2) 

목표: s의 부분문자열(substring)중 가장 긴 팰린드롬의 길이를 구하시오.

팰린드롬: 앞뒤를 뒤집어도 똑같은 문자열

완전탐색1: (슬라이딩 윈도우)
1. 길이1 ~ s길이 윈도우
2. 길이i인 윈도우를 슬라이딩하며, 각 슬라이딩마다 펠린드롬을 확인한다.
O(S * S * S) -> TLE
3. 길이 s인 윈도우부터 시작하여, 펠린드롬 확인되면 바로 break
-> TLE 예상
-> 시도하다 취소

완전탐색2:
1. 홀수길이 펠린드롬
s[i]를 중심으로 하는 펠린드롬 확인
-> O(S * S)

2. 짝수길이 팰린드롬
s[i], s[i+1]를 중심으로 하는 펠린드롬 확인
-> O(S * S)

-> 가능할듯?

설계
1. 홀수길이 팰린드롬 확인
s[i]를 중심으로 양 옆이 점진적으로 계속 같은지 확인하며, 팰린드롬 길이를 업데이트한다.

2. 짝수길이 팰린드롬 확인
s[i], s[i+1]를 중심으로 양 옆이 점진적으로 계속 같은지 확인하며, 팰린드롬 길이를 업데이트한다.
단, s[i]와 s[i+1]은 같아야 함.


*/

import java.util.*;

class Solution {
    public int solution(String s) {
        // pro(s);
        int answer = pro(s);
        return answer;
    }
    
    private int pro(String s) {
        
        //홀수길이 (3부터) 펠린드롬 확인
        int maxPalindromeLength = 1;    //최소한, 자기자신만 있는 문자도 팰린드롬이므로, 1로 초기화
        for(int mid=0; mid<s.length(); mid++) {
            int palindromeLength = 0;
            for(int left=mid-1, right=mid+1; 0<=left && right<s.length(); left--, right++) {
                char leftChar = s.charAt(left);
                char rightChar = s.charAt(right);
                if(leftChar != rightChar) {
                    break;
                }
                palindromeLength = Math.abs(mid - left) * 2 + 1;
            }
            maxPalindromeLength = Math.max(maxPalindromeLength, palindromeLength);
        }
        
        //짝수길이 팰린드롬 확인
        for(int mid1=0, mid2=1; mid2<s.length(); mid1++, mid2++) {
            // 중앙의 두 문자가 다르면 팰린드롬이 아니다.
            if(s.charAt(mid1) != s.charAt(mid2)) {
                continue;
            }
            // 팰린드롬 시작
            int palindromeLength = 0;
            for(int left=mid1-1, right=mid2+1; 0<=left && right<s.length(); left--, right++) {
                char leftChar = s.charAt(left);
                char rightChar = s.charAt(right);
                if(leftChar != rightChar) {
                    break;
                }
                palindromeLength = Math.abs(mid1 - left) * 2 + 2;    //+1이 아닌, +2임에 주의
            }
            maxPalindromeLength = Math.max(maxPalindromeLength, palindromeLength);
        }
        return maxPalindromeLength;
    }
}
