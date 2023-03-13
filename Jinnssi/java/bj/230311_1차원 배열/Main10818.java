import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main10818 {

    public static void main(String args[]) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	int N = Integer.parseInt(br.readLine()); // 정수 갯수 
    	StringTokenizer st = new StringTokenizer(br.readLine()," ");
    	int arr[] = new int[N];
    	for(int i=0; i<N; i++) {
    		arr[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	int max = arr[0];
    	int min = arr[0];
    	
        for(int j=1; j<arr.length; j++) {
        	if(max < arr[j]) {
        		max = arr[j];
        	}
        	else if(min > arr[j]) {
        		min = arr[j];
        	}
        }
        
        bw.write(min+" "+max+"\n");
        bw.flush();
        br.close();
        bw.close();
    }
}