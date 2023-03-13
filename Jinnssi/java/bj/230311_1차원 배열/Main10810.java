import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main10810 {

    public static void main(String args[]) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());// 바구니 갯수
        int M = Integer.parseInt(st.nextToken());// 공 넣는 횟수
    	// i번 바구니부터 j번 바구니까지에 k번 번호가 적혀져 있는 공
    	int arr[] = new int[N]; 
    	
    	for(int l=0; l<M; l++) {
    		st = new StringTokenizer(br.readLine()," ");
    		int start = Integer.parseInt(st.nextToken());
    		int end = Integer.parseInt(st.nextToken());
    		int num = Integer.parseInt(st.nextToken()); 
    		for(int w=start-1; w<end; w++) {
    			arr[w] = num;
    		}
    	}
    	
    	String result = "";
    	for(int a=0; a<arr.length; a++) {
    		result += arr[a]+" ";
    	}
        bw.write(result+"\n");
        bw.flush();
        br.close();
        bw.close();
    }
}