package baekjun.src.baekjun.BackTrack;

import java.io.*;
import java.util.*;
public class Main1487 {

    static int n;
    static int[][] a;
    static StringTokenizer st;
    static ArrayList<Sejun> s = new ArrayList<Sejun>();
    static class Sejun implements Comparable<Sejun>{
        int measure_price, profit, num;

        public Sejun(int measure_price, int profit, int num){
            this.measure_price = measure_price;
            this.profit = profit;
            this.num = num;
        }

        public String toString(){
            return "측정가격 : " + measure_price + ", 얻은 이익 : " + profit + ", 번호 : " + num;
        }

        public int compareTo(Sejun other){
            if(this.profit == other.profit){
                return other.measure_price - this.measure_price;
            }
            return this.profit - other.profit;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        a = new int[n][2];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int money = Integer.parseInt(st.nextToken());
            int move_fee = Integer.parseInt(st.nextToken());
            a[i][0] = money;
            a[i][1] = move_fee;
        }
        pro();
    }

    static void pro(){
        int coin = 0;
        for(int i=0; i<n; i++){
            int sum = 0;
            coin = a[i][0];
            for(int j=0; j<n; j++){
                if(a[j][0] >= coin && coin > a[j][1]){
                    sum += coin;
                    sum -= a[j][1];
                }
            }
            s.add(new Sejun(coin, sum, i));
        }

        Collections.sort(s, Collections.reverseOrder());
        //System.out.println(s);
        if(s.get(0).profit != 0){
            System.out.println(s.get(0).measure_price);
        } else {
            System.out.println(0);
        }
    }
}
