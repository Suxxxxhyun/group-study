import java.util.*;

/*
2023.06.06
소요시간: 23분
유형: 큐
*/

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new LinkedList<>();
        for(int i=0; i<bridge_length; i++) {
            bridge.add(0);
        }
        
        Queue<Integer> trucks = new LinkedList<>();
        for(int truck_weight: truck_weights) {
            trucks.add(truck_weight);
        }
        
        int truckCount = 0, truckWeight = 0, time = 0;
        while(!trucks.isEmpty()) {
            time ++;
            int out = bridge.poll();
            if(out != 0) { truckCount --; }    
            truckWeight -= out;
            if(truckCount < bridge_length && truckWeight + trucks.peek() <= weight) {
                truckWeight += trucks.peek();
                bridge.add(trucks.poll());
                truckCount ++;
            } else {
                bridge.add(0);
            }
        }
        return time + bridge_length;
    }
}
