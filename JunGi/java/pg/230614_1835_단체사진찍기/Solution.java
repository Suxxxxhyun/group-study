/*
2023.06.14
time: 09:38 ~ 10:10 (32m solve)
Goal: 각 프렌즈가 원하는 조건을 입력으로 받았을 때, 모든 조건을 만족할 수 있도록 서는 경우의 수
Type: 순열 완탐 + 구현
-> 총 참가자가 8명으로 매우 적음에 힌트
-> 8명을 줄세우는 경우의 수를 모두 구하고 (순열)
-> 각각의 경우의 수 (base case)에 대해 모든 조건 (data)를 만족하는지 확인

[설계]
1. 순열 구하기
2. base case 도달 시 -> 모든 조건이 성립하는지 확인

ex. 
1. 순열 [A, F, C, J, M, R, T, N]
2. base case
 - 구한 순열의 각 참가자들의 순서를 알파벳 배열에 기록 (최적화 해야하므로)
 - [1(A), (B), 3(C), (D), (E), 2(F), ...]
 - 조건에 맞는지 검출

*/
import java.util.*;

class Solution {
    private char[] persons = new char[] {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    private char[] order = new char[8];
    private String[] data;
    private int n, answer;
    public int solution(int n, String[] data) {
        this.data = data;
        this.n = n;
        // int answer = 0;
        permutation(0, 0, new boolean[8]);
        return answer;
    }
    
    private void permutation(int idx, int count, boolean[] visited) {
        // base:
        if(count == 8) {
            checkData();
            return;
        }
        
        // recur:
        for(int i=0; i<persons.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                order[count] = persons[i];
                permutation(i, count+1, visited);
                visited[i] = false;
                order[count] = ' ';
            }
        }
    }
    
    private void checkData() {
        int[] personsOrder = new int[26];   // {A, C, F, J, M, N, R, T}의 순위 기록
        for(int idx=0; idx<order.length; idx++) {
            personsOrder[order[idx] - 'A'] = idx + 1;
        }
        boolean flag = false;
        for(String d: data) {
            char personA = d.charAt(0);
            char personB = d.charAt(2);
            char condition = d.charAt(3);
            int distance = d.charAt(4) - '0';
            
            int personDistance = Math.abs(personsOrder[personA-'A'] - personsOrder[personB-'A']) - 1;
            if(condition == '=') {
                if(personDistance != distance) {
                    flag = true;
                    break;
                }
            } else if(condition == '>') {
                if(personDistance <= distance) {
                    flag = true;
                    break;
                }
            } else {
                if(personDistance >= distance) {
                    flag = true;
                    break;
                }
            }
        }
        if(!flag) {
            answer++;
        }
    }
}
