package Level2;

import java.util.*;

class Solution12952 {

    int answer = 0;
    ArrayList<Integer> column = new ArrayList<Integer>(); //[0]

    public int solution(int n) {

        dfs(n,0);
        return answer;
    }

    void dfs(int n, int row){
        if(row == n){
            answer += 1;
            return;
        }

        for(int i=0; i<n; i++){
            if(pruning(i)){
                column.add(i);
                dfs(n, row + 1);
                column.remove(column.size()-1);
            }
        }
    }

    boolean pruning(int col){
        int nextRow = column.size();
        for(int i=0; i<nextRow; i++){
            //가만보면 호석님은 어떻게 조건 판별했었지? -> 더한값이 같음과 뺀값이 같음을 확인함.
            if(col == column.get(i) || (Math.abs(col - column.get(i)) == nextRow - i) ){
                return false;
            }
        }
        return true;
    }
}
