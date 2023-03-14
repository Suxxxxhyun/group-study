package baekjun.Tree;

import java.io.*;
import java.util.*;

public class Main199102 {
	
	static int n;
	static Map<String, List<String>> map = new HashMap<>();

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			String[] temp = br.readLine().split(" ");
			List<String> list = new ArrayList<>();
			
			list.add(temp[1]);
			list.add(temp[2]);
			
			map.put(temp[0],list);
		}
		
		preorder("A");
		System.out.println();
		inorder("A");
		System.out.println();
		postorder("A");
	}
	
	static void preorder(String v) {
		if(v.equals(".")) {
			return;
		}
		
		System.out.print(v);
		preorder(map.get(v).get(0));
		preorder(map.get(v).get(1));
	}
	
	static void inorder(String v) {
		if(v.equals(".")) {
			return;
		}
		
		inorder(map.get(v).get(0));
		System.out.print(v);
		inorder(map.get(v).get(1));
	}
	
	static void postorder(String v) {
		if(v.equals(".")) {
			return;
		}
		
		postorder(map.get(v).get(0));
		postorder(map.get(v).get(1));
		System.out.print(v);
	}

}
