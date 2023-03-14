import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main10811 {

    public static void main(String args[]) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int[] arr = new int[Integer.parseInt(st.nextToken())];
    	for(int l=0; l<arr.length; l++) {
    		arr[l] = l+1;
    	}
    	int m = Integer.parseInt(st.nextToken());
    	for (int i = 0; i < m; i++) {
    		st = new StringTokenizer(br.readLine());
    		int a = Integer.parseInt(st.nextToken())-1;   
    		int b = Integer.parseInt(st.nextToken())-1; 
			while (a < b) { 
				int temp = arr[a]; 
				arr[a++] = arr[b]; 
				arr[b--] = temp;
			}

		}
    	for(int num:arr) {
    		bw.write(num+" ");
    	}
    	bw.write("\n");
        bw.flush();
        br.close();
        bw.close();
    }
}


