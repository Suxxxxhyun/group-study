package Level2;

//최소한의 객실만을 사용해서 예약손님을 받으려고 함.
//한번사용했으면 10분간 청소하고 다음 손님을 받음
//9:16 ~ 9:46
import java.util.*;

public class Solution155651 {

    class Node implements Comparable<Node>{
        int start, end;

        public Node(int start, int end){
            this.start = start;
            this.end = end;
        }

        public int compareTo(Node other){
            if(this.start == other.start){
                return this.end - other.end;
            }
            return this.start - other.start;
        }

        public String toString(){
            return "start = " + start + ", end = " + end;
        }
    }

    int answer = 0;

    public int solution(String[][] book_time) {

        List<Node> list = new ArrayList<Node>();

        for(int i=0; i<book_time.length; i++){
            String[] s = book_time[i][0].split(":");
            int sh = Integer.parseInt(s[0]);
            int sm = Integer.parseInt(s[1]);

            String[] e = book_time[i][1].split(":");
            int eh = Integer.parseInt(e[0]);
            int em = Integer.parseInt(e[1]);

            list.add(new Node(sh * 60 + sm, eh * 60 + em + 10));
        }

        Collections.sort(list);

        //종료시간을 기준으로 오름차순
        PriorityQueue<Node> pq = new PriorityQueue<Node>(new Comparator<Node>(){
            public int compare(Node n1, Node n2){
                return n1.end - n2.end;
            }
        });

        pq.offer(list.get(0));
        answer += 1;

        if(list.size() > 1){
            for(int i=1; i<list.size(); i++){
                if(list.get(i).start < pq.peek().end){
                    pq.offer(list.get(i));
                    answer += 1;
                    //System.out.println(pq);
                } else {
                    pq.poll();
                    pq.offer(list.get(i));
                    //System.out.println(pq);
                }
            }
        }
        return answer;
    }
}
