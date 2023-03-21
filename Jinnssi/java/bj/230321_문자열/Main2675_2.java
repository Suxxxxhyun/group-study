import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main2675_2 {

    public static void main(String args[]) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	int s = Integer.parseInt(br.readLine());
    	StringTokenizer st;
    	StringBuilder sb = new StringBuilder();
    	String str;
    	int cnt;
    	for(int i=0; i<s; i++) {
    		st = new StringTokenizer(br.readLine());
    		cnt = Integer.parseInt(st.nextToken()); //3
    		str = st.nextToken();// abcd
    		for(int j=0; j<str.length(); j++) {// a
    			for(int k=0; k<cnt; k++) {
    				sb.append(str.charAt(j));
    			}
    		}
    		bw.write(sb.toString());
    		bw.newLine();
    		sb.setLength(0);// 길이를 0으로 만들어 초기화
    	}
    	bw.flush();
    	bw.close();
    }
}