package Level2;

import java.util.*;

//블로그풀이를 활용한 내풀이
public class Solution176962 {

    class Work{
        String name;
        int start, playtime;

        public Work(String name, int start, int playtime) {
            this.name = name;
            this.start = start;
            this.playtime = playtime;
        }
    }
    public List<String> solution(String[][] plans){
        List<String> answer = new ArrayList<String>();

        PriorityQueue<Work> pq = new PriorityQueue<Work>(
                (o1, o2) -> (o1.start - o2.start)
        );

        for(int i = 0; i < plans.length; i++) {
            String name = plans[i][0];

            String[] str = plans[i][1].split(":");
            int h = Integer.parseInt(str[0]);
            int m = Integer.parseInt(str[1]);
            int start = (h * 60) + m;

            int time = Integer.parseInt(plans[i][2]);

            pq.add(new Work(name, start, time));
        }

        Stack<Work> stack = new Stack<Work>();

        while(!pq.isEmpty()) {
            Work cur = pq.poll();

            String curName = cur.name;
            int curStart = cur.start;
            int curPlaytime = cur.playtime;

            int currentTime = curStart;

            if(!pq.isEmpty()) {
                Work next = pq.peek();

                if(next.start < curStart + curPlaytime) {
                    int t = next.start - curStart;
                    stack.push(new Work(curName, curStart, curPlaytime - t));
                } else if(next.start == curStart + curPlaytime) {
                    answer.add(curName);
                } else {
                    answer.add(curName);
                    currentTime += curPlaytime; //1시반

                    while(!stack.isEmpty()) {
                        Work rem = stack.pop();

                        if(currentTime + rem.playtime > next.start) {
                            int t = next.start - currentTime;
                            stack.push(new Work(rem.name, rem.start, rem.playtime - t));
                            break;
                        } else {
                            currentTime += rem.playtime;
                            answer.add(rem.name);
                        }
                    }
                }
            } else {
                answer.add(curName);
                while(!stack.isEmpty()) {
                    answer.add(stack.pop().name);
                }
            }
        }

        return answer;
    }
}
