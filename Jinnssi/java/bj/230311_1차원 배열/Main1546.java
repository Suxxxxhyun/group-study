import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1546 {

    public static void main(String args[]) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken()); 
    	double[] arr = new double[N];
    	st = new StringTokenizer(br.readLine());
    	for(int i=0; i<arr.length; i++) {
    		arr[i] = Double.parseDouble(st.nextToken()); 
    	}
    	double sum = 0;
    	Arrays.sort(arr);
    	for(double num:arr) {
    		sum += (num/arr[arr.length-1])*100;
    	}
    	bw.write(sum/arr.length+"\n");
        bw.flush();
        br.close();
        bw.close();
    }
}


