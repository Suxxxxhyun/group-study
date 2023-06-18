/*
2023.06.18
14:30 ~ 15:21 (30분 설계, 20분 구현, 1분 디버깅(런타임에러))
*/
import java.util.*;

class Solution {
    private Map<String, Integer> carAndInTime = new HashMap<>();
    private Map<String, Integer> carAndTotalTime = new HashMap<>();
    public int[] solution(int[] fees, String[] records) {
    
        for(String record: records) {
            String[] info = recordParser(record);
            String[] time = timeParser(info[0]);
            
            int date = getDate(time[0], time[1]);
            String car = info[1];
            String type = info[2];
            
            // "IN"이면 InTime을 기록한다.
            if(type.equals("IN")) {
                carAndInTime.put(car, date);
            } else {
            // "OUT"이면 주차장누적시간(OutDate - InDate)을 누적한다. InTime은 제거한다.
                int inDate = carAndInTime.get(car);
                int total = date - inDate;
                carAndTotalTime.put(car, carAndTotalTime.getOrDefault(car, 0) + total);
                carAndInTime.remove(car);
            }
        }
        
        // 출차기록이 없는 차량은 23:59에 출차된 것으로 간주한다.
        for(String car: carAndInTime.keySet()) {
            int inDate = carAndInTime.get(car);
            int total = 1439 - inDate;
            carAndTotalTime.put(car, carAndTotalTime.getOrDefault(car, 0) + total);
            // carAndInTime.remove(car);    // -> runtime error
        }
        
        // 요금을 계산한다.
        List<Car> temp = new ArrayList<>();
        for(String car: carAndTotalTime.keySet()) {
            int totalTime = carAndTotalTime.get(car);
            int price = calculatePrice(totalTime, fees);
            temp.add(new Car(Integer.parseInt(car), price));
        }
        
        Collections.sort(temp, (o1, o2) -> o1.carNum - o2.carNum);
        int[] answer = new int[temp.size()];
        for(int idx=0; idx<answer.length; idx++) {
            answer[idx] = temp.get(idx).price;
        }
        return answer;
    }
    
    private int getDate(String hour, String minute) {
        return Integer.parseInt(hour) * 60 + Integer.parseInt(minute);
    }
    
    private String[] recordParser(String record) {
        return record.split(" ");
    }
    
    private String[] timeParser(String time) {
        return time.split(":");
    }
    
    private int calculatePrice(int totalTime, int[] fees) {
        int baseTime = fees[0];
        int basePrice = fees[1];
        int unitTime = fees[2];
        int unitPrice = fees[3];
        
        if(totalTime <= baseTime) {
            return basePrice;
        }
        return basePrice + (int)Math.ceil(((double) totalTime - (double) baseTime) / (double) unitTime) * unitPrice;
    }   
}

class Car {
    int carNum;
    int price;
    
    public Car(int carNum, int price) {
        this.carNum = carNum;
        this.price = price;
    }
}
