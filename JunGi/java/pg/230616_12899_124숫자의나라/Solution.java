/*

14:02 ~ 

[유형]
Goal: 자연수 n에 대한 124나라의 숫자 구하기
-> 124나라는 "중복순열"
-> nums = 1, 2, 4에 대한, n번째 중복순열을 구하시오.

유형1. dfs로 "중복순열" 구하면 스택 터짐
유형2. 반복문으로 "중복순열" 구하기 -> 못구함, 시간초과

유형3. Queue 활용 + StringBuilder -> 효율성 TLE
유형4. 규칙찾기
규칙1. n이 3의배수일 때 -> 4를 추가
규칙2. n이 3의배수가 아닐 때 -> n % 3을 추가
규칙3. n = (n-1) / 3

124숫자나라 -> 1,2,4로 이루어진 중복순열?

*/
import java.util.*;

class Solution {
    public String solution(int n) {
        String answer = solve2(n);
        return answer;
    }
    
    private String solve2(int n) {
        StringBuilder sb = new StringBuilder();
        while(n!=0) {
            if(n%3 == 0) {
                sb.insert(0, "4");
            } else {
                sb.insert(0, String.valueOf(n%3));
            }
            n = (n-1) / 3;
        }
        return sb.toString();
    }
    
    private String solve1TLEfail(int n) {
        String answer = "";
        
        Queue<String> queue = new LinkedList<>();
        queue.add("");
        StringBuilder sb = new StringBuilder();
        int count = 0;
        //O(50_000_000 * while문 1회 시간복잡도)
        // -> while문 내부가 O(10)만 돼도 TLE
        while(true) {
            String cur = queue.poll();  //O(1)
            sb.setLength(0);    //O(?)
            String temp = sb.append(cur).append("1").toString();    //O(?)
            count++;
            queue.add(temp);    //O(1)
            if(count == n) {
                answer = temp;
                break;
            }
            
            sb.setLength(0);
            temp = sb.append(cur).append("2").toString();
            count++;
            queue.add(temp);
            if(count == n) {
                answer = temp;
                break;
            }
            
            sb.setLength(0);
            temp = sb.append(cur).append("4").toString();
            count++;
            queue.add(temp);
            if(count == n) {
                answer = temp;
                break;
            }   
        }
        return answer;
    }
}
