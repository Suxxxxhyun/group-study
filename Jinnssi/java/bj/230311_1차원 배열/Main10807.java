import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main10807 {

    public static void main(String args[]) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	int N = Integer.parseInt(br.readLine()); // 정수 갯수 
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(br.readLine()); // 찾으려고 하는 정수 
        int cnt = 0;
        for(int i=0; i<N; i++) {
        	if(Integer.parseInt(st.nextToken()) == v) ++cnt;
        }
        bw.write(cnt+"\n");
        bw.flush();
        br.close();
        bw.close();
    }
}