import java.util.Scanner;
import java.util.StringTokenizer;

public class Main3003 {

    public static void main(String args[]){
    	 Scanner sc = new Scanner(System.in);
    	 String str = sc.nextLine();;
    	 StringTokenizer st = new StringTokenizer(str," ");
    	 int arr[] = new int[6];
    	 arr[0] = 1; arr[1] = 1; arr[2] = 2; arr[3] = 2; arr[4] = 2; arr[5] = 8;
    	 StringBuilder sb = new StringBuilder();
    	 for(int i=0; i<arr.length; i++) {
    		 int num = Integer.parseInt(st.nextToken());
    		 if(arr[i]!=num) {
    			 sb.append(arr[i]-num+" ");
    		 }else {
    			 sb.append(0+" ");
    		 }
    	 }
    	 System.out.println(sb.toString());
    	 
    }
}