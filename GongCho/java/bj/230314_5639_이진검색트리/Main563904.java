package baekjun.Tree;

import java.io.*;

public class Main563904 {
	
	static class Node{
		Node left;
		Node right;
		int value;
		
		static Node head = null;
		
		public Node() {
			
		}
		
		public Node(int value) {
			this.value = value;
		}
		
		void insert(int value) {
			if(Node.head == null) {
				Node.head = new Node(value);
			} else {
				Node current = head;
				
				while(true) {
					if(current.value > value) {
						if(current.left == null) {
							current.left = new Node(value);
							break;
						} else {
							current = current.left;
						}
					} else {
						if(current.right == null) {
							current.right = new Node(value);
							break;
						} else {
							current = current.right;
						}
					}
				}
			}
		}
	}
	
	static void postorder(Node root) {
		if(root == null) {
			return;
		}
		
		postorder(root.left);
		postorder(root.right);
		System.out.println(root.value);
	}

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Node node = new Node();
		while(true) {
			String st = br.readLine();
			if(st == null || st.equals("")) {
				break;
			}
			node.insert(Integer.parseInt(st));
		}
		
		postorder(Node.head);
	}

}
