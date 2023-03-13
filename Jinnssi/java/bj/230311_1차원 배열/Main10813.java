import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main10813 {

    public static void main(String args[]) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());// 바구니 갯수
        int M = Integer.parseInt(st.nextToken());
    	int arr[] = new int[N]; 
    	for(int i=0; i<arr.length; i++) {
    		arr[i] = i+1;
    	}
    	for(int l=0; l<M; l++) {
    		st = new StringTokenizer(br.readLine()," ");
    		int a = Integer.parseInt(st.nextToken());
    		int b = Integer.parseInt(st.nextToken());
    		int num1 = arr[a-1];
    		int num2 = arr[b-1];
    		arr[a-1] = num2;
    		arr[b-1] = num1;
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