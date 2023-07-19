package Programmers.Lv3;

import java.util.*;

class Node {
    String word;
    int cnt;

    Node(String word, int cnt) {
        this.word = word;
        this.cnt = cnt;
    }
}
public class PG_43163_230719 {
    boolean[] visited;
    public int solution(String begin, String target, String[] words) {

        visited = new boolean[words.length];

        return bfs(begin, target, words);
    }

    // 하나씩 바꿔 가야함
    public int bfs(String begin, String target, String[] words) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(begin, 0));

        while (!q.isEmpty()) {
            Node cur = q.poll();
            // 큐의 단어 target과 같은 경우
            if (cur.word.equals(target)) return cur.cnt;

            for (int i = 0; i < words.length; i++) {
                int match = 0; // 하나만 다른 단어 찾기
                for (int j = 0; j < begin.length(); j++) {
                    if (cur.word.charAt(j) == words[i].charAt(j)) match++;
                }

                if (!visited[i] && match == cur.word.length() - 1) {
                    q.add(new Node(words[i], cur.cnt+1));
                    visited[i] = true;
                }
            }
        }
        // 모든 조건 만족하지 못 할 경우
        return 0;
    }
}
