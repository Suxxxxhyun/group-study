package Programmers;

public class Solution8130102 {

	public static void main(String[] args) {
		
		Solution8130102 s = new Solution8130102();
		System.out.println(s.solution("23four5six7"));

	}
	
	public int solution(String s) {
		//int answer = 0;
		
		String[] digit = {"1","2","3","4","5","6","7","8","9"};
		String[] alpha = {"one","two","three","four","five","six","seven","eight","nine"};
		
		for(int i=0; i<9; i++) {
			s = s.replace(alpha[i], digit[i]);
		}
		
		return Integer.parseInt(s);
	}

}
