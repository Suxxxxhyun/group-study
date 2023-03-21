import java.util.Scanner;

public class Main2675 {

    public static void main(String args[]){
    	Scanner sc = new Scanner(System.in);
    	int s = Integer.parseInt(sc.nextLine());
    	String str;
    	StringBuilder sb = new StringBuilder();
    	int cnt;

    	for(int i=0; i<s; i++) {
    		cnt = sc.nextInt();
    		str = sc.next();
    		for(int j=0; j<str.length(); j++) {// a
    			for(int k=0; k<cnt; k++) {
    				sb.append(str.charAt(j));
    			}
    		}
    		System.out.println(sb.toString());
    		sb.setLength(0);// 길이를 0으로 만들어 초기화
    	}
    }                                             
}