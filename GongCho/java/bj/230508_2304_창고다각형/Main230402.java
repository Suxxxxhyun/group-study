package baekjun.simulation;

import java.io.*;
import java.util.*;

public class Main230402 {
	
	static int n, start = 1001, end = 0;
	static StringTokenizer st;
	static int[] a = new int[1001];

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int L = Integer.parseInt(st.nextToken());
			int H = Integer.parseInt(st.nextToken());
			a[L] = H;
			start = Math.min(start, L);
			end = Math.max(end, L);
		}
		
		Stack<Integer> height = new Stack<Integer>();
		
		int temp = a[start];
		for(int i=start + 1; i<=end; i++) {
			//현재높이가 이전의 높이보다 낮다면
			if(a[i] < temp) {
				height.push(i);
			}
			//현재높이가 이전의 높이보다 크거나 같다면
			else {
				while(!height.isEmpty()) {
					a[height.pop()] = temp;
				}
				temp = a[i];
			}
		}
		
		//height.clear();
		
		temp = a[end];
		for(int i=end - 1; i>=start; i--) {
			//현재높이가 이전의 높이보다 낮다면
			if(a[i] < temp) {
				height.push(i);
			}
			//현재높이가 이전의 높이보다 크거나 같다면
			else {
				while(!height.isEmpty()) {
					a[height.pop()] = temp;
				}
				temp = a[i];
			}
		}
		
		int result = 0;
		for(int i=start; i<=end; i++) {
			result += a[i];
		}
		System.out.println(result);
	}

}
