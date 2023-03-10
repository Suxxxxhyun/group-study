import java.util.Scanner;

public class Main10952 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 입력받은 값 두개가 0 일경우엔 입력 끝
		int A=1,B=1;
		while(true) {
			A = sc.nextInt();
			B = sc.nextInt();
			if(!(A*B==0)) System.out.println(A+B);
			else break;
		}
		sc.close();
    }
}

