import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main5597 {

    public static void main(String args[]) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	int arr[] = new int[30];
        for(int i=0; i<28; i++) {
        	int n = Integer.parseInt(br.readLine());
			arr[n-1]=-1;
    	}
        for(int k=0; k<arr.length; k++) {
        	if(arr[k]!=-1) {
        		bw.write((k+1)+"\n");
        	}
        }
        bw.flush();
        br.close();
        bw.close();
    }
}