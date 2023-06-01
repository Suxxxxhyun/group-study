import java.util.*;
/*
[리뷰]
소요시간: 약 40분 (설계10분, 구현30분)
오래걸린이유: 문자열 parsing이 오래걸림..

[설계]
1. 문자열 S 파싱
 ex. String s = {{1,2,3},{2,1},{1,2,4,3},{2}}
 String[] parsed = [{2}, {2,1}, {1,2,3}, {1,2,4,3}] (각 집합 원소개수 오름차순)

2. 처음 만나는 원소 차례로 뽑기 (by Set)
*/
class Solution {
    public int[] solution(String s) {
        List<Tuple> tuples = getTuples(s);
        int[] answer = getAnswer(tuples);
        return answer;
    }
    
    private int[] getAnswer(List<Tuple> tuples) {
        List<Integer> tempAnswer = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for(int idx = 0; idx<tuples.size(); idx++) {
            Tuple t = tuples.get(idx);
            String temp = t.elements.replace("{", "");
            temp = temp.replace("}", "");

            String[] nums = temp.split(",");
            for(String num: nums) {
                if(!set.contains(num)) {
                    tempAnswer.add(Integer.parseInt(num));
                    set.add(num);
                }
            }
        }
        int[] answer = new int[tuples.size()];
        for(int idx=0; idx<answer.length; idx++) {
            answer[idx] = tempAnswer.get(idx);
        }
        return answer;
    }
    
    private List<Tuple> getTuples(String str) {
        String[] tempInfo = str.split("},");
        List<Tuple> tuples = new ArrayList<>();
        for(String s: tempInfo) {
            int count = 0;
            for(int idx=0; idx<s.length(); idx++) {
                if(s.charAt(idx) == ',') {
                    count ++;
                }
            }
            tuples.add(new Tuple(s, count+1));
        }
        Collections.sort(tuples, (o1, o2) -> o1.count- o2.count);
        return tuples;
    }
}

class Tuple {
    String elements;
    int count;
    
    public Tuple(String elements, int count) {
        this.elements = elements;
        this.count = count;
    }
}
