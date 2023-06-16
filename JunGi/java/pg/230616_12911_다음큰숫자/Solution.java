/*
13:45 ~ 14:00
Goal: 자연수 n이 주어졌을 때, n의 다음 큰 숫자를 리턴
Type: 단순구현, 진수변환
*/
class Solution {
    public int solution(int n) {
        String binary1 = Integer.toBinaryString(n);
        int answer = n + 1;
        while(true) {
            String binary2 = Integer.toBinaryString(answer);
            if(isSameOneNumCount(binary1, binary2)) {
                break;
            }
            answer ++;
        }
        return answer;
    }
    
    private boolean isSameOneNumCount(String binary1, String binary2) {
        int b1OneNumCount = getOneNumCount(binary1);
        int b2OneNumCount = getOneNumCount(binary2);
        return b1OneNumCount == b2OneNumCount;
    }
    
    private int getOneNumCount(String binary) {
        int oneNumCount = 0;
        for(char c: binary.toCharArray()) {
            if (c == '1') {
                oneNumCount++;
            }
        }
        return oneNumCount;
    }
}
