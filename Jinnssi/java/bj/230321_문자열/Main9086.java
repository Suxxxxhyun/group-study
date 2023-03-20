import java.util.Scanner;

public class Main9086 {

    public static void main(String args[]) {
    	Scanner sc = new Scanner(System.in);
    	int n = sc.nextInt();
    	StringBuilder sb ;
    	String str;
    	for(int i=0; i<n; i++) {
    		sb = new StringBuilder();
    		str= sc.next();
			sb.append(str.charAt(0));
			sb.append(str.charAt(str.length()-1));
			System.out.println(sb.toString());
    	}
    	sc.close();
    }
}