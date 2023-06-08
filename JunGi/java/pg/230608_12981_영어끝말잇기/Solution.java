import java.util.*;
/*
2023.06.08
소요시간: 17분 (설계 5분, 구현 10분, 디버깅 2분)

Goal: 가장먼저 탈락하는 사람의 번호, 자신의 몇번째에 탈락하는지 구하기
유형: Input Size에 따라, 단순 구현문제

끝말잇기 탈락조건
1. 이전에 등장한 단어 -> Set으로 관리
2. 끝말잇기가 아닌경우 ex. str1: hello  str2: world

탈락하는 사람의 번호, 몇번째인지 뭔가 배열 idx에 따라 구할 수 있을 것 같았음.
탈락하는 사람의 번호: idx % 전체인원 + 1
몇번째인지: 전체인원 배수마다 전체횟수 증가
-> 사람번호, idx 배열 그려놓고 규칙 찾기
*/

class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> usedWords = new HashSet<>();
        int count = 0;
        for(int i=0; i<words.length; i++) {
            if(i%n == 0) {
                count++;
            }
            // 탈락조건 1: 이전에 등장한 단어일 경우
            if(usedWords.contains(words[i])) {
                return new int[] {i%n+1, count};
            }
            // 탈락조건 2: 끝말잇기가 아닌 경우
            if(i!=0 && 
               words[i-1].charAt(words[i-1].length()-1) != words[i].charAt(0)) {
                return new int[] {i%n+1, count}; 
            }
            usedWords.add(words[i]);
        }       
        return new int[] {0, 0};
    }
}
