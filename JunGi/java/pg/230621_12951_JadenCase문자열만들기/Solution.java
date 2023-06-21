/*
2023.06.21
08:37 ~ 09:00
문자열 parsing runtime error
-> 공백문자가 연속해서 나올 수 있는 경우


*/
import java.util.*;

class Solution {
    public String solution(String s) {
        // String answer = solve1(s);
        String answer = solve2(s);
        return answer;
    }
    
    private String solve2(String s) {
        StringBuilder sb = new StringBuilder();
        s = s.toLowerCase();
        for(int idx=0, n=s.length(); idx<n; idx++) {
            char c = s.charAt(idx);
            // 공백문자나 숫자인 경우
            if(c == ' ' || ('a' > c || 'z' < c)) {
                sb.append(c);
            } else {
            // 알파벳인데 첫번째 자리인 경우
                if(idx==0 || (idx!=0 && s.charAt(idx-1) == ' ')) {
                    sb.append((char) (c - 32));
                } else {
                    sb.append(c);
                }
            }
        }
        
        String answer = sb.toString();
        return answer;
    }
    
    private String solve1Fail(String s) {
        StringBuilder sb = new StringBuilder();
        s = s.toLowerCase();
        String[] parsed = s.split("");
        System.out.println(Arrays.toString(parsed));
        for(String str: parsed) {
            if('a' <= str.charAt(0) && str.charAt(0) <= 'z') {
                sb.append((char)(str.charAt(0) - 32));
                sb.append(str.substring(1, str.length()));
            } else {
                sb.append(str.substring(0, str.length()));
            }
        }
        String answer = sb.toString().trim();
        System.out.println(answer);
        return answer;
    }
}
