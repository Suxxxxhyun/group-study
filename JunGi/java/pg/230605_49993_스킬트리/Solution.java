import java.util.*;
/*
2023.06.05
소요시간: 45분 (시간단축, 다른 풀이 복습 필요)
오래걸린 이유:
1. char == '' 비교 안됨. char == Character_MIN_VALUE로 비교
2. 디버깅

Goal: 가능한 스킬트리 개수
유형: 단순구현
*/
class Solution {
    public int solution(String skill, String[] skill_trees) {
        boolean[] skills = new boolean[26];
        char[] prevSkills = new char[26];
        initialSkills(skill, skills, prevSkills);
        
        int count = 0;
        for(String cur: skill_trees) {
            boolean[] learned = new boolean[26];
            boolean can = true;
            for(char c: cur.toCharArray()) {
                // 선행스킬에 없으면 무조건 가능하다.
                if(!skills[c-'A']) {continue;}
                // 선행스킬에 있으면 확인한다.
                    // 이전스킬이 없는 경우 가능하다.
                if(prevSkills[c-'A'] == '1') {
                    learned[c-'A'] = true;
                    continue;
                }
                if(prevSkills[c-'A'] == Character.MIN_VALUE && !learned[c-'A']) {
                    learned[c-'A'] = true;
                }
                // 이전스킬이 있고, 이전스킬을 배웠다면 가능하다.
                else if(prevSkills[c-'A'] != Character.MIN_VALUE && learned[prevSkills[c-'A'] - 'A']){
                    learned[c-'A'] = true;
                } 
                else {
                    can = false;
                }
            }
            if (can) {
                count++;
            }
        }
        return count;
    }
    
    private void initialSkills(String skill, boolean[] skills, char[] prevSkills) {
        for(char c: skill.toCharArray()) {
            skills[c-'A'] = true;
        }
        prevSkills[skill.charAt(0) - 'A'] = '1';
        for(int idx=1; idx<skill.length(); idx++) {
            prevSkills[skill.charAt(idx) - 'A'] = skill.charAt(idx-1);
        }
    }
}
