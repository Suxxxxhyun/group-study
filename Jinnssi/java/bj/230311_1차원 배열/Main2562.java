import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main2562 {

    public static void main(String args[]) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	int max=100;
    	int n=0;
    	for(int j=1; j<10; j++) {
    		int N = Integer.parseInt(br.readLine()); // 정수 갯수
    		
    		if(j == 1) {
    			max = N;
    			n = 1;
    		}else {
    			if(max < N) {
    				max = N;
    				n = j;
    			}
    		}
        }
        
        bw.write(max+"\n");
        bw.write(n+"\n");
        bw.flush();
        br.close();
        bw.close();
    }
}