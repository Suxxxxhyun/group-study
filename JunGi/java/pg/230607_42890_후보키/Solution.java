import java.util.*;

/* 2023.06.07
시간: 45분
오래걸린이유: 구현부분 디버깅, 최소성 만족 구현 오래걸림
유형: 조합 완탐 + 구현
*/

class Solution {
    private static int answer = 0;
    private static List<Integer> keys = new ArrayList<>();
    public int solution(String[][] relation) {
        combi(0, -1, relation);
        return answer;
    }
    
    private void combi(int count, int idx, String[][] relation) {
        
        // base:
        if(count == relation[0].length) {
            return;
        }
        
        // recur:
        for(int i=idx+1; i<relation[0].length; i++) {
            keys.add(i);
            if(isUnique(relation) && isMinimum(relation)) {
                answer++;
            }
            combi(count+1, i, relation);
            keys.remove(count);
        }
    }
    
    /* 유일성 확인
    key값으로 중복된 튜플이 없으면 유일성 만족
    */
    private boolean isUnique(String[][] relation) {
        Set<String> set = new HashSet<>();
        for(int row=0; row<relation.length; row++) {
            String tuple = "";
            for(int col: keys) {
                tuple = tuple + relation[row][col];
            }
            set.add(tuple);
        }
        if(set.size() == relation.length) {
            return true;
        }
        return false;
    }
    
    /* 최소성 확인
    key값들 중 하나를 제외하고도 유일성을 만족하면 최소성을 만족하지 않는다.
    */
    private boolean isMinimum(String[][] relation) {
        for(int excluseCol: keys) {     //key값들 중 하나 제외
            Set<String> set = new HashSet<>();
            for(int row=0; row<relation.length; row++) {
                String tuple = "";
                for(int col: keys) {    //key값들 중 하나 제외
                    if(excluseCol == col) { continue; }
                    tuple = tuple + relation[row][col];
                }
                set.add(tuple);
            }
            if(set.size() == relation.length) { //유일성을 만족하면 최소성 만족 x
                return false;
            }
        }
        return true;
    }
}
