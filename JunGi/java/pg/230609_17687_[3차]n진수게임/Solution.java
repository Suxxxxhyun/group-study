/*
23.06.09 (44분 fail (풀이참고))

틀린이유: 10진수 -> 2, 8, 10, 16진수가 아니라, 10진수 -> 2 ~ 16진수를 구해야 함
오래걸린이유: 참가인원 m명 중 튜브순서 p를 처리하는데 오래걸림. 복습, 최적화 필요

진수변환 메소드 복습필요
1) int num -> N진수 String
Integer.toString(num, N);
*/

class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        
        int count = 0, turn = 1, num = 0;
        // int temp = 20;
        // while(temp --> 0) {
        while(count != t) {
            String numStr = tenToN(num, n);
            // System.out.println("numStr: " + numStr);
            for(int i=0; i<numStr.length(); i++) {
                // turn -= 1;
                
                if(turn == p) {
                    answer += numStr.charAt(i);
                    count++;
                    if(turn == m) {
                        turn = 1;
                    } else {
                        turn ++;
                    }
                } else if(turn == m) {
                    turn = 1;
                } else {
                    turn ++;
                }
                // System.out.printf("Char: %c, turn: %d, count: %d\n", numStr.charAt(i), turn, count);
                // System.out.println("answer: " + answer);
                if(count == t) {
                    break;
                }
            }
            num++;
        }
        
        return answer.toUpperCase();
    }
    
    private String tenToN(int num, int n) {
        // if(n==2) {
        //     return Integer.toBinaryString(num);
        // }
        // if(n==8) {
        //     return Integer.toOctalString(num);
        // }
        // if(n==16) {
        //     return Integer.toHexString(num);
        // }
        return Integer.toString(num, n);
        
        // return String.valueOf(num);
    }
}
