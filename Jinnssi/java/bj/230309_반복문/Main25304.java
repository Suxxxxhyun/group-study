import java.util.Scanner;

public class Main25304 {
	
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		int X = sc.nextInt();// 총금액 
		int N = sc.nextInt();// 종류 
		
		int total=0; // 실제 총액 
		int a,b=0;
		for(int i=0; i<=N; i++) {
			if(sc.hasNextInt()) {
				a = sc.nextInt();
				b = sc.nextInt();
				total +=a*b;
			}
		}
        
		sc.close();
        
        String result=""; //출력값 
        result=(X==total)?"Yes":"No"; 
        System.out.println(result);
	}
}
