/*
2023.06.01
유형: 단순구현
시간: 7분
설계: 지문 그대로 구현
*/
class Solution {
    public int solution(String s) {
        if(s.length() == 1) {return 1;}
        int answer = divider(s);
        return answer;
    }
    
    private int divider(String s) {
        char x = s.charAt(0);
        int count = 0;
        int sameCount = 1, differentCount = 0;
        for(int idx=1; idx<s.length(); idx++) {
            char c = s.charAt(idx);
            if(c == x) { sameCount++; }
            else { differentCount++; }
            if(sameCount == differentCount) {
                count++;
                sameCount = 0;
                differentCount = 0;
                if(idx != s.length()-1) {
                    x = s.charAt(idx+1);
                }
            } else if(idx == s.length()-1) {
                count++;
            }
        }
        return count;
    }
}
