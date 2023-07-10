import java.util.*;
import java.io.*;

/** 2023.07.10 (09:19 ~ 09:55. 36m solve)

 제한: 2초, 512mb
 입력:
  1. 식재료 개수 N (3 ~ 15)

 goal: 최저 영양소 기준을 만족하는 최소 비용의 식재료 집합 (조합) 구하기
 - 같은 비용의 집합이 하나 이상일 수 있다. (가장 빠른 것 출력)
 - 최소 비용을 만족하는 식재료 집합이 없을 수 있다. (-1 출력)

 
 설계
 -> 모든 조합 구하고, O(15 C 7) -> 6500 * 15
 -> 방문마다, 최소 영양소 기준을 만족하는지 확인하고,
 -> 만족하면, 최소여부로 갱신

 */

public class Main {
    private static int N, mp, mf, ms, mv, minCost = Integer.MAX_VALUE;
    private static List<Food> foods, combiFoods;
    private static List<Integer> result;
    public static void main(String[] args) throws IOException {
        input();
        combiFoods = new ArrayList<>();
        combi(-1);

        if(minCost == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }

        StringBuilder sb = new StringBuilder();
        for(int i: result) {
            sb.append(i).append(" ");
        }

        System.out.println(minCost);
        System.out.println(sb);
    }

    private static void combi(int idx) {
        // check:
        if(validateMin()) {
            int cost = getCost();
            if(cost < minCost) {
                minCost = cost;
                result = getFoodNum();
            }
        }

        // base:
        if(idx == N) {
            return;
        }

        // recur:
        for(int i = idx + 1; i < N; i++) {
            combiFoods.add(foods.get(i));
            combi(i);
            combiFoods.remove(combiFoods.size() - 1);
        }
    }

    // 조합 foods가 최소 영양소 기준을 만족하는지 확인
    private static boolean validateMin() {
        int totalP = 0;
        int totalF = 0;
        int totalS = 0;
        int totalV = 0;

        for(Food food: combiFoods) {
            totalP += food.p;
            totalF += food.f;
            totalS += food.s;
            totalV += food.v;
        }

        return ((totalP >= mp) && (totalF >= mf) && (totalS >= ms) && (totalV >= mv));
    }

    private static int getCost() {
        int cost = 0;
        for(Food food: combiFoods) {
            cost += food.cost;
        }
        return cost;
    }

    private static List<Integer> getFoodNum() {
        List<Integer> list = new ArrayList<>();
        for(Food food: combiFoods) {
            list.add(food.num);
        }
        return list;
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        String[] minInfo = br.readLine().split(" ");
        mp = Integer.parseInt(minInfo[0]);
        mf = Integer.parseInt(minInfo[1]);
        ms = Integer.parseInt(minInfo[2]);
        mv = Integer.parseInt(minInfo[3]);

        initFoods(br);
    }

    private static void initFoods(BufferedReader br) throws IOException {
        foods = new ArrayList<>();
        for(int foodCount=1; foodCount<=N; foodCount++) {
            String[] foodInfo = br.readLine().split(" ");
            int p = Integer.parseInt(foodInfo[0]);
            int f = Integer.parseInt(foodInfo[1]);
            int s = Integer.parseInt(foodInfo[2]);
            int v = Integer.parseInt(foodInfo[3]);
            int cost = Integer.parseInt(foodInfo[4]);

            foods.add(new Food(foodCount, p, f, s, v, cost));
        }
    }
}

class Food {
    int num;
    int p;  // 단
    int f;  // 지
    int s;  // 탄
    int v;  // 비
    int cost;

    public Food(int num, int p, int f, int s, int v, int cost) {
        this.num = num;
        this.p = p;
        this.f = f;
        this.s = s;
        this.v = v;
        this.cost = cost;
    }

    public String toString() {
        return String.format("%d, %d, %d, %d, %d\n", p, f, s, v, cost);
    }
}
