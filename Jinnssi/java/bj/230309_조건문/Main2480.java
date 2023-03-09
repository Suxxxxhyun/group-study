import java.util.Scanner;

public class Main2480 {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();

        int r = 0;
        if(A==B && B==C && C==A) r=10000+(A*1000);
        else if(A==B || B==C || C==A) {
        	if(A==B || A==C) r=1000+(A*100);
        	else if(C==B) r=1000+(B*100);
        }
        else {
        	if(A>B && A>C) r=A*100;
        	else if(B>A && B>C) r=B*100;
        	else r=C*100;
        }

        System.out.println(r);
        sc.close();

    }
}