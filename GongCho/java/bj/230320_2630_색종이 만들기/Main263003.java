package baekjun.DivideAndConquer;
//~2:10까지 시작
import java.io.*;
import java.util.*;

public class Main263003 {
	
	static int n, white, blue;
	static StringTokenizer st;
	static int[][] map;

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		partiton(0,0,n);
		System.out.println(white);
		System.out.println(blue);
	}
	
	static void partiton(int x, int y, int size) {
		
		//일단, rowSize와 colSize는 계속 같은 값을 가지기때문에 파라미터를 2개로 할 필요가 없음.
		if(check(x, y, size)) {
			if(map[x][y] == 0) {
				white++;
			} else {
				blue++;
			}
			return;
		}
		
		partiton(x, y, size/2);
		partiton(x, y + size/2, size/2);
		partiton(x + size/2, y, size/2);
		partiton(x + size/2, y + size/2, size/2);
		
	}
	
	static boolean check(int x, int y, int size) {
		int color = map[x][y];
		for(int i=x; i<x+size; i++) {
			for(int j=y; j<y+size; j++) {
				if(color != map[i][j]) {
					//System.out.println("false");
					return false;
				}
			}
		}
		return true;
	}

}
