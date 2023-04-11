package Programmers;

import java.util.*;

public class Solution42885 {
	
	int answer = 0;
	//[30,40,50,60]
	public int solution(int[] people, int limit) {
		
		Arrays.sort(people);
		for(int L=0, R=people.length-1; L<=R; R--) {
			if(people[L] + people[R] <= limit) {
				L++;
			}
			answer++;
		}
		return answer;
	}
}
