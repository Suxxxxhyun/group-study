package Level2;

//9:51 ~ 10:30
//투포인터같은데?
import java.util.*;

class Solution178870 {

    class Pair implements Comparable<Pair>{
        int left, right, ans;

        public Pair(int left, int right, int ans){
            this.left = left;
            this.right = right;
            this.ans = ans;
        }

        public String toString(){
            return "left = " + left + ", right = " + right;
        }

        public int compareTo(Pair other){
            if(this.ans == other.ans){
                return this.left - other.left;
            }
            return this.ans - other.ans;
        }
    }

    int[] answer = new int[2];
    ArrayList<Pair> list = new ArrayList<Pair>();

    public int[] solution(int[] sequence, int k) {

        int sum = 0;
        for(int L=0, R=0; L<sequence.length; L++){
            while(R + 1 <= sequence.length && sum < k){
                sum += sequence[R++];
            }
            //System.out.println(sum);
            if(sum == k){
                list.add(new Pair(L, R-1, R-L));
            }
            sum -= sequence[L];
        }
        Collections.sort(list);

        answer[0] = list.get(0).left;
        answer[1] = list.get(0).right;
        return answer;
    }
}
