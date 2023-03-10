import java.util.Scanner;

public class Main8393 {
	
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int arr[] = new int[T];
		int A,B;
		for(int i=0; i<T; i++) {
			A = sc.nextInt();
			B = sc.nextInt();
			arr[i] = A+B;
		}
		sc.close();
        
        for(int i=0; i<T; i++) {
            System.out.println(arr[i]);
		}
		
	}
}
