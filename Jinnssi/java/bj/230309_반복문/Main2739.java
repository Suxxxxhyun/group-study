import java.util.Scanner;

public class Main2739 {
	
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		for(int i=1; i<10; i++) {
			System.out.println(A+" "+"*"+" "+i+" "+"="+" "+A*i);
		}
		sc.close();
	}
}
