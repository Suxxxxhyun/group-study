import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main10871 {

    public static void main(String args[]) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int N = Integer.parseInt(st.nextToken()); // 정수 갯수 
    	int X = Integer.parseInt(st.nextToken()); // 정수 갯수 
    	
    	st = new StringTokenizer(br.readLine());
        
    	String result = "";
        
        for(int i=0; i<N; i++) {
        	int a = Integer.parseInt(st.nextToken());
        	if(X > a) result += a+" ";
        }
        
        bw.write(result+"\n");
        bw.flush();
        br.close();
        bw.close();
    }
}