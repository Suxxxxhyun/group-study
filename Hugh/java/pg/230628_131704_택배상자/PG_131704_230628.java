package Programmers;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PG_131704_230628 {

    /**
     * 09:07~10:20
     *
     * main = Queue
     * sub = Stack
     *
     * pre 에 이전값 저장하면서 진행.
     * pre 갱신시 마다 result++
     *
     * 초기메인 = ->  5, 4, 3, 2, 1 ->
     * order 첫번째 보다 작으면 sub로
     *
     * sub = 1,2,3(Stack) ->
     *
     * pre진행 = 4,3
     *
     */

    public static void main(String[] args) {
        int[] order = new int[]{4, 3, 1, 2, 5};
        Stack<Integer> subStack = new Stack<>();
        Queue<Integer> mainQueue = new LinkedList<>();

        int result = 0;

        for (int i = 1; i <= order.length; i++) {
            mainQueue.offer(i);
        }

        int pre = 0;
        for (int val : order) { // 4, 3, 1, 2, 5
            while (true) {
                // 2. 상자 번호가 현재 상자보다 작다면 서브 컨베이어
                if (val < pre) {
                    if (subStack.peek() == val) { // 같기때문에 갱신
                        pre = subStack.pop();
                        result++;
                        break;
                    } else {
                        System.out.println(result);
                        break;
                    }
                }
                // 1. 초기 main 순회로 시작
                else if (!mainQueue.isEmpty()) {
                    if (mainQueue.peek() == val) {
                        pre = mainQueue.poll();
                        result++;
                        break;
                    } else {
                        subStack.push(mainQueue.poll());
                    }
                }
            }
        }

    }
}

