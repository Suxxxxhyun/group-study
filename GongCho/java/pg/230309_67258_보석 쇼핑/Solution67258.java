package Level3;

import java.util.*;

class Solution67258 {

    static Map<String,Integer> present = new HashMap<String,Integer>();
    static Map<String,Integer> con = new HashMap<String,Integer>();
    static int kind = 0;
    static ArrayList<Node> list = new ArrayList<Node>();
    static ArrayList<Integer> answer = new ArrayList<Integer>();

    static class Node implements Comparable<Node>{
        int start, end, len;

        public Node(int start, int end, int len){
            this.start = start;
            this.end = end;
            this.len = len;
        }

        public int compareTo(Node other){
            if(this.len == other.len){
                return this.start - other.start;
            }
            return this.len - other.len;
        }

        public String toString(){
            return "start = " + start + ", end = " + end;
        }
    }

    public ArrayList<Integer> solution(String[] gems) {

        for(int i=0; i<gems.length; i++){
            if(!present.containsKey(gems[i])){
                present.put(gems[i], 1);
            } else {
                present.put(gems[i], present.get(gems[i]) + 1);
            }
        }

        Iterator<String> iter = present.keySet().iterator();
        while(iter.hasNext()){
            con.put(iter.next(), 0);
        }

        for(int L=0,R=0; L<gems.length; L++){
            while(R + 1 <= gems.length && kind < present.size()){
                add(gems[R++]);
            }


            if(kind >= present.size()){
                erase(gems[L]);
                list.add(new Node(L + 1,R-1 + 1,R - L + 1));
            }
        }

        Collections.sort(list);
        //System.out.println(list);
        answer.add(list.get(0).start);
        answer.add(list.get(0).end);
        return answer;
    }

    static void add(String x){
        if(con.get(x) == 0){
            kind++;
        }
        con.put(x,con.get(x) + 1);
    }

    static void erase(String x){
        con.put(x,con.get(x)-1);

        if(con.get(x) == 0){
            kind--;
        }
    }
}