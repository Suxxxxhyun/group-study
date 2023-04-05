package Programmers;

public class Solution14010802 {

	public int solution(String s) {
		char prev = '1';
		int same = 0, different = 0, answer = 0;
		
		
		//일차원 배열의 원소를 확인하고 싶을때, Arrays.toString(일차원배열이름);
		//이렇게 사용하면, for문 없이도 원소 확인가능!
		for(char c : s.toCharArray()) {
			if(prev == '1') {
				prev = c;
				answer++;
				same++;
			} else if(prev == c) {
				same++;
			} else {
				different++;
			}
			
			if(same == different) {
				prev = '1';
				same = 0;
				different = 0;
			}
		}
		
		return answer;
	}

}
