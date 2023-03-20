import java.util.Scanner;

public class Main27866 {

    public static void main(String args[]) {
    	Scanner sc = new Scanner(System.in);
    	String str= sc.nextLine();
    	int num = sc.nextInt();
    	char result = ' ';
    	for(int i=0; i<str.length(); i++) {
    		if(i+1==num)  
    			result = str.charAt(i);
    	}
    	System.out.println(result);
    	sc.close();
    }
}