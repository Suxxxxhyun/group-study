package SWExpertAcademy;

import java.io.*;

public class Solution1974 {

    static int t, count;
    static int[][] a;
    static boolean[][] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++) {
            a = new int[9][9];
            visited = new boolean[9][9];
            count = 0;
            for(int i=0; i<9; i++) {
                String str = br.readLine();
                String[] num = str.split(" ");
                for(int j=0; j<num.length; j++) {
                    a[i][j] = Integer.parseInt(num[j]);
                }
            }

			/*for(int i=0; i<9; i++) {
				for(int j=0; j<9; j++) {
					System.out.print(a[i][j] + " ");
				}
				System.out.println();
			}*/
            boolean value = pro1();
            //System.out.println(value);
            pro2(0,0,3);
            boolean val = pro3();
            sb.append("#").append(t+1).append(' ');
            if(value && count == 9 && val) {
                sb.append(1).append('\n');
            } else {
                sb.append(0).append('\n');
            }
        }
        System.out.println(sb);

    }

    //가로줄, 세로줄이 모두 한번씩 나오는가 -> 일단 가로줄만 확인함.
    static boolean pro1() {

        int[] number;
        int cnt = 1;

        for(int i=0; i<9; i++) {
            number = new int[9];
            for(int j=0; j<a[i].length; j++) {
                number[a[i][j] - 1]++;
            }

            for(int c=0; c<number.length; c++) {
                if(number[c] != cnt) {
                    return false;
                }
            }
        }
        return true;
    }

    static boolean pro3() {

        int[] number;
        int cnt = 1;

        for(int i=0; i<9; i++) {
            number = new int[9];
            for(int j=0; j<9; j++){
                number[a[j][i] - 1]++;
            }

            for(int c=0; c<number.length; c++) {
                if(number[c] != cnt) {
                    return false;
                }
            }
        }
        return true;
    }

    //3*3격자판이 완벽히 1부터 9까지의 숫자를 이루는가
    static void pro2(int x, int y, int size) {

        if(x == 9 || y == 9) {
            return;
        }

        if(check(x,y,size)) {
            count += 1;
        }

        pro2(x+3,y,size);
        pro2(x,y+3,size);

    }

    static boolean check(int x, int y, int size) {
        int[] number = new int[9];
        int cnt = 1;

        for(int i=x; i<x+size; i++) {
            for(int j=y; j<y+size; j++) {
                if(!visited[i][j]) {
                    number[a[i][j] - 1]++;
                    visited[i][j] = true;
                } else {
                    return false;
                }
            }
        }

        for(int c=0; c<number.length; c++) {
            if(number[c] != cnt) {
                return false;
            }
        }
        return true;

    }

}

