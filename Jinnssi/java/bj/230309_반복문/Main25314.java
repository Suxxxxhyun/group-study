import java.util.Scanner;

public class Main25314 {
	
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); 
		String result=""; //출력값 
		
		for(int i=0; i<N/4; i++) {
			result += "long "; 
		}
		
		result += "int";
		sc.close();
        System.out.println(result);
	}
}
