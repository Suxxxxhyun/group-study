import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int tc = 0; tc < T; tc ++) {
            List<Integer> cards = toList(br.readLine());
            int zeroCount = Collections.frequency(cards, 0);
            if(isEdgeCase(cards, zeroCount)) {
                sb.append("0\n");
                continue;
            }
            removeTarget(cards, zeroCount);
            long result = pro(cards, zeroCount);
            sb.append(String.format("%d\n", result));
        }
        System.out.println(sb.toString());
    }

    private static boolean isEdgeCase(List<Integer> cards, int zeroCount) {
        if(zeroCount == cards.size() || zeroCount == cards.size() - 1) {
            return true;
        }
        return false;
    }

    private static long pro(List<Integer> cards, int zeroCount) {
        long card1 = cards.get(0);
        long card2 = 0L;

        for(int idx=1; idx<cards.size(); idx++) {
            int num = cards.get(idx);
            if(card1 < card2) {
                card1 = card1 * 10L + num;
            } else {
                card2 = card2 * 10L + num;
            }
        }

        long result = card1 * card2;
        for(int i=0; i<zeroCount; i++) {
            result *= 10;
        }
        return result;
    }

    private static void removeTarget(List<Integer> list, int targetCount) {
        while(targetCount --> 0) {
            list.remove(list.size() - 1);
        }
    }

    private static List<Integer> toList(String input) {
        List<Integer> list = new ArrayList<>();
        for(char c: input.toCharArray()) {
            if(c == '6') {
                list.add(9);
            } else {
                list.add(c - '0');
            }
        }
        Collections.sort(list, Comparator.reverseOrder());
        return list;
    }
}
