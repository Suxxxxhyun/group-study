package Level2;

//10:16 ~ 11:32
//끝나는 구간이 오히려 우선순위가 될 수 있음.
import java.util.*;

class Solution181188 {

    class Scope implements Comparable<Scope>{
        int x, y;

        public Scope(int x, int y){
            this.x = x;
            this.y = y;
        }

        public int compareTo(Scope other){
            if(this.y == other.y){
                return this.x - other.x;
            }
            return this.y - other.y;
        }

        public String toString(){
            return "x = " + this.x + ", y = " + this.y;
        }

    }

    int answer = 1, s = 0;
    ArrayList<Scope> list = new ArrayList<Scope>();

    public int solution(int[][] targets) {

        for(int i=0; i<targets.length; i++){
            list.add(new Scope(targets[i][0], targets[i][1]));
        }

        Collections.sort(list);
        s = list.get(0).y;

        for(int i=1; i<list.size(); i++){
            if(s <= list.get(i).x){
                s = list.get(i).y;
                answer +=1;
            }
        }
        return answer;
    }
}
