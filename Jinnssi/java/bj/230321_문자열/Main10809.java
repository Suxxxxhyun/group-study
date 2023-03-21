import java.util.Scanner;

public class Main10809 {

    public static void main(String args[]){
    	Scanner sc = new Scanner(System.in);
    	String str = sc.nextLine();
    	sc.close();
    	int used[] = new int[26];
    	for(int i=0; i<26; i++) {
    		int num = str.indexOf((char)('a'+i));
    		// a b c d .. 인덱스 위치 찾기 
    		used[i]= num;
    	}
    	
    	for(int num : used) {
    		System.out.print(num+" ");
    	}
    }
}