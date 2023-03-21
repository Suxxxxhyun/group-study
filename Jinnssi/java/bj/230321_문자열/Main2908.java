import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2908 {

    public static void main(String args[])throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	String A = st.nextToken();
    	String B = st.nextToken();
    	StringBuilder sb = new StringBuilder();
    	for(int i=A.length()-1; i>=0; i--) {
    		sb.append(A.charAt(i));
    	}
    	int reverse_A = Integer.parseInt(sb.toString());
    	sb.setLength(0);
    	for(int i=B.length()-1; i>=0; i--) {
    		sb.append(B.charAt(i));
    	}
    	int reverse_B = Integer.parseInt(sb.toString()); 
    	if(reverse_A>reverse_B) {
    		System.out.println(reverse_A);
    	}else {
    		System.out.println(reverse_B);
    	}
    	
	}
    	
}