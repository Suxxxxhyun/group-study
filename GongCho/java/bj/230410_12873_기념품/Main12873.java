package baekjun.simulation;

import java.io.*;
import java.util.*;

public class Main12873 {
	
	static int n;
	static Deque<Integer> q = new LinkedList<Integer>();
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		for(int i=1; i<=n; i++) {
			q.offer(i);
		}
		pro();

	}
	
	static void pro() {
		long beak = 1;
		while(q.size() > 1) {
			for(int i=0; i< beak * beak * beak % q.size(); i++) {
				q.offer(q.pollFirst());
			}
			q.pollLast();
			beak++;
		}
		System.out.println(q.peek());
	}

}
