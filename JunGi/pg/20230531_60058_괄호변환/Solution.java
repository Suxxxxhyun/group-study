import java.util.*;
/*
소요시간: 1시간
오래걸린이유: 문제 파악이 오래걸렸음 (3, 40분)

[유형]
Goal: "균형잡힌 괄호 문자열" --> "올바른 괄호문자열" 변환
문제의 지문을 확인해보면 결국 "재귀" 문제임을 파악할 수 있음.

[재귀 설계]
** 모르겠으면 State Space Tree 그려보고, 각 재귀마다 어떤 일이 발생하는지 파악할 것! **
SST를 그려보면 결국 다음의 사항을 확인할 수 있음.

base case:
1. 문자열이 빈문자열인 경우
recursive case:
1. 연결된 곳: 문자열 u, v
2. 갈 수 있는 곳: 문자열 v
3. 방문처리:
 - 문자열 u가 올바른 괄호 문자열인 경우 u는 그대로 냅둠
 - 문자열 u가 올바른 괄호 문자열이 아닌 경우 u의 맨 앞, 맨 뒤 제거하고 나머지 괄호는 reverse
*/
class Solution {
    public String solution(String p) {
        String result = converter(p);
        return result;
    }
    
    private String converter(String p) {
        
        // base1: 빈 문자열
        if(p.equals("")) return p;
        
        // 연결된 곳: v
        String[] info = getUAndV(p);
        String u = info[0];
        String v = info[1];
        
        if(isCorrectString(u)) {
            String result = u + converter(v);
            return result;
        } else {
            String result = "(" + converter(v);
            result += ")";
            result += reverseString(u);
            return result;
        }    
    }
    
    private String reverseString(String p) {
        String reverse = "";
        for(int idx = 1; idx<p.length()-1; idx++) {
            char c = p.charAt(idx);
            if(c == ')') {
                reverse += '(';
            } else {
                reverse += ')';
            }
        }
        return reverse;
    }
    
    private boolean isCorrectString(String p) {
        Stack<Character> validator = new Stack<>();
        for(char c: p.toCharArray()) {
            if(validator.isEmpty()) { validator.add(c); }
            else {
                if(c == ')' && validator.peek() == '(') {
                    validator.pop();
                } else {
                    validator.add(c);
                }
            }
        }
        return validator.isEmpty();
    }
    
    private String[] getUAndV(String p) {
        int count1 = 0, count2 = 0, uEnd = 0;
        for(int idx=0; idx<p.length(); idx++) {
            char c = p.charAt(idx);
            if(c == '(') { count1 ++; }
            else { count2 ++; }
            if(count1 == count2) {
                uEnd = idx;
                break;
            }
        }
        return new String[] {p.substring(0, uEnd+1), p.substring(uEnd+1, p.length())};
    }
}
