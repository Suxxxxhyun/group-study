package Programmers.Lv2;

import java.util.*;
public class PG_42860_230720 {

// BBAAAAAYYY
// CCCAAAAAAY

    public int solution(String name) {
        int answer = 0;
        int move = name.length() - 1;

        for (int i = 0; i < name.length(); i++) {
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);

            int idx = i + 1;

            // 내 다음 알파벳이 'A'라면 끝나는 지점 구하기
            while (idx < name.length() && name.charAt(idx) == 'A') {
                idx++;
            }

            // 오른쪽으로 갔다가 왼쪽으로 이동
            move = Math.min(move, (i * 2) + name.length() - idx);

            // 왼쪽으로 갔다가 오른쪽으로 이동
            move = Math.min(move, i + (name.length() - idx) * 2);
        }
        return answer + move;
    }
}
