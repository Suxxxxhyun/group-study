import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main3052 {

    public static void main(String args[]) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	int num=10;
    	int arr[] = new int[num];
        for(int i=0; i<num; i++) {
        	arr[i] = Integer.parseInt(br.readLine())%42;
    	}
        
        for(int i=0; i<10; i++) {
        	for(int j=0; j<arr.length; j++) {
        		if(j>i) {
        			if(arr[i]==arr[j]) --num;
        		}else break;
        	}
        }
        bw.write(num+"\n");
        bw.flush();
        br.close();
        bw.close();
    }
}





