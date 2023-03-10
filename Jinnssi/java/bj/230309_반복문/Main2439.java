import java.util.Scanner;

public class Main2439 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		sc.close();
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n-i; j++) {
				System.out.print(" ");
			}
			for(int K=0; K<i; K++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
    }
}

