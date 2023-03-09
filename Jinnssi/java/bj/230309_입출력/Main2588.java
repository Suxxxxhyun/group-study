//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.Scanner;

public class Main2588 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int B = false;
		int A = sc.nextInt();
		int B = sc.nextInt();
		int[] arr = new int[3];

		for(int i = 0; i < 3; ++i) {
			arr[i] = String.valueOf(B).charAt(i) - 48;
		}

		System.out.println(A * arr[2]);
		System.out.println(A * arr[1]);
		System.out.println(A * arr[0]);
		System.out.println(A * B);
		sc.close();
	}
}
