package Programmers;

public class PG_148653_230320 {
    public static void main(String[] args) {
//        System.out.println(solution());
    }
    static int solution(int storey) {
        int answer = 0;

        while(storey != 0) {
            int current = storey % 10;
            int next = (storey / 10) % 10;

            if(current > 5) {
                answer += (10 - current);
                storey += 10;
            } else if(current == 5) {
                answer += 5;
                storey += (next >= 5) ? 10 : 0;
            } else {
                answer += current;
            }

            storey /= 10;
        }

        return answer;
    }
}
