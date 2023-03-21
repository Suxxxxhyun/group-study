package Level2;

import java.util.*;
//이 문제 끝나고 나면, 정렬 다시 해보기

class Solution147354 {

    //int answer = 0;
    int[][] a;
    ArrayList<Integer> list = new ArrayList<Integer>();

    public int solution(int[][] data, int col, int row_begin, int row_end) {

        a = new int[data.length][3];
        for(int i=0; i<data.length; i++){
            a[i][0] = i; //행번호
            a[i][1] = data[i][0]; //기본키
            a[i][2] = data[i][col-1]; //col번째의 원소
        }

        Arrays.sort(a, new Comparator<int[]>(){
            public int compare(int[] o1, int[] o2){
                if(o1[2] == o2[2]){
                    return o2[1] - o1[1];
                }
                return o1[2] - o2[2];
            }
        });

        for(int i=row_begin - 1; i<= row_end - 1; i++){
            int pk = a[i][1];
            int sum = 0;
            for(int j=0; j<data.length; j++){
                if(pk == data[j][0]){
                    for(int k=0; k<data[j].length; k++){
                        sum += data[j][k] % (i + 1);
                    }
                }
            }
            list.add(sum);
        }

        for(int i=0; i<list.size(); i++){
            System.out.println(list.get(i));
        }

        int val = 0;
        int n1 = list.get(0);
        for(int i=1; i<list.size(); i++){
            int n2 = list.get(i);
            val = n1 ^ n2;
            n1 = val;
        }

        /*for(int i=0; i<data.length; i++){
            System.out.println(a[i][0] + " " + a[i][1] + " " + a[i][2]);
        }*/
        return val;
    }
}
