import java.util.*;

/** 2023.07.19 (09:05 ~ 09:36)
리뷰: bfs 떠오르는게 쉽진 않았음. SST 그려보고 떠올림.

입력:
 1. 각 단어의 길이M: 3 ~ 10 (모두 같음, 소문자)
 2. 단어의 개수 N: 3 ~ 50 (중복x)
 3. 가능 시간복잡도: O(N^4), O(M!)

목표: begin -> target으로 변환하는 가장 짧은 변환 과정 찾기
-> BFS

<변환>
1. 한 번에 한 개의 알파벳만 바꿀 수 있는데
2. 바꾸려는 알파벳이 words에 존재해야 함

BFS 설계:
*edge: target이 words에 없는 경우
- 목적지: target
- 연결: words
- 갈수: 방문하지 않았고, 알파벳 하나만 차이


*/

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = bfs(begin, target, words);
        return answer;
    }
    
    private int bfs(String begin, String target, String[] words) {
        Queue<Word> queue = new LinkedList<>();
        boolean[] visited = new boolean[words.length];
        settingBfsStart(begin, queue);
        
        while(!queue.isEmpty()) {
            Word curInfo = queue.poll();
            String cur = curInfo.word;
            int cost = curInfo.cost;
            
            if(cur.equals(target)) {
                return cost;
            }
            for(int idx=0; idx<words.length; idx++) {
                String next = words[idx];
                if(!visited[idx] && isOneAlphaDifference(cur, next)) {
                    visited[idx] = true;
                    queue.add(new Word(next, cost+1));
                }
            }
            
        }
        
        return 0;
    }
    
    private boolean isOneAlphaDifference(String cur, String next) {
        int diffCount = 0;
        for(int idx=0; idx<cur.length(); idx++) {
            if(cur.charAt(idx) != next.charAt(idx)) {
                diffCount++;
            }
        }
        return diffCount == 1;
    }
    
    private void settingBfsStart(String begin, Queue<Word> q) {
        q.add(new Word(begin, 0));
        // begin과 target은 같지 않다.
        // target은 words에 존재한다. (edge는 이미 검증)
        // 따라서, begin은 words에 존재하지 않는다.
        // 따라서, visited check 필요 x
    }
}

class Word {
    String word;
    int cost;
    
    public Word(String word, int cost) {
        this.word = word;
        this.cost = cost;
    }
    
    public String toString() {
        return word + ", " + cost;
    }
}
