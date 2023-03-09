//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.Scanner;

public class Main10430 {
	public Main10430() {
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int C = false;
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		System.out.println((A + B) % C);
		System.out.println((A % C + B % C) % C);
		System.out.println(A * B % C);
		System.out.println(A % C * (B % C) % C);
		sc.close();
	}
}
