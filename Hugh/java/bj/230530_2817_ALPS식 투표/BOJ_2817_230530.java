package BOJ.Implementation;

import java.io.*;
import java.util.*;

public class BOJ_2817_230530 {
    static class Staff {
        String name;
        int votes;
        int chip = 0;
        Queue<Integer> arr = new LinkedList<>(); // 점수 집합

        public Staff (String name, int votes) {
            this.name = name;
            this.votes = votes;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int X = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        ArrayList<Staff> list = new ArrayList<Staff>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int votes = Integer.parseInt(st.nextToken());

            if ((X * 0.05) < votes) {
                list.add(new Staff(name, votes));
            }
        }
        list.sort(Comparator.comparing(o -> o.name)); // 스테프 이름순 정렬

        for (Staff staff : list) {
            for (int j = 1; j <= 14; j++) {
                staff.arr.offer(staff.votes / j);
            }
        }

        int cnt = 14;
        while (cnt-- > 0) {
            int max = 0;
            int num = 0; // 가장 점수 집합이 높은 스테프 찾기 위한 변수
            for (int i = 0; i < list.size(); i++) {
                Staff staff = list.get(i);
                int peek = staff.arr.peek();
                if (max < peek) {
                    max = peek;
                    num = i;
                }
            }
            Staff staff = list.get(num);
            staff.arr.poll(); // 점수 집합에서 제거
            staff.chip++;
        }

        list.forEach(staff -> sb.append(String.format("%s %d\n", staff.name, staff.chip)));
        bw.write(sb.toString());
        bw.flush();

        bw.close();
        br.close();
    }
}
