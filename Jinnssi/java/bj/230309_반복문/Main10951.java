import java.util.Scanner;

public class Main10951 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 입력받은 값 두개가 0 일경우엔 입력 끝
		while (sc.hasNextInt()) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(a+b);
        }
		sc.close();
    }
}

