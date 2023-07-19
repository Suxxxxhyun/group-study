import java.util.*;

/** 2023.07.19 (13:04 ~ 13:35)

리뷰:
차에 대한 카메라를 생각하지말고,
카메라가 어떤 위치에 있을 때, 그 카메라에 차량이 많이 찍히려면 차들이 어떻게 배치되고 
카메라 이동이 어떻게 갱신되는지 파악하면 훨씬 쉬움

입력:
 1. 차량수 N: 1 ~ 10,000
 2. 가능 시간 복잡도: O(N^2), O(N)
 
목표: 모든 차량이 한번은 단속용 카메라를 만나도록 하기위한 최소 카메라 개수
*/

class Solution {
    public int solution(int[][] routes) {
        List<Car> carRoutes = toListAscendingByInTime(routes);
        int answer = pro(carRoutes);
        return answer;
    }
    
    private int pro(List<Car> routes) {
        int cameraCount = 1;
        int cameraPosition = routes.get(0).outTime;
        
        for(int idx=1; idx<routes.size(); idx++) {
            Car cur = routes.get(idx);
            //1. 카메라 바꿔야 하는가?
            if(cameraPosition < cur.inTime) {
                cameraCount ++;
                cameraPosition = cur.outTime;
            } else {            
            //2. 아니라면, 현재 카메라 위치는 조정해야 하는가?
                cameraPosition = Math.min(cameraPosition, cur.outTime);
            }
        }
        return cameraCount;
    }
    
    private List<Car> toListAscendingByInTime(int[][] routes) {
        List<Car> list = new ArrayList<>();
        for(int i=0; i<routes.length; i++) {
            list.add(new Car(routes[i][0], routes[i][1]));
        }
        Collections.sort(list, (o1, o2) -> o1.inTime - o2.inTime);
        return list;
    }
}

class Car{
    int inTime;
    int outTime;
    
    public Car(int inTime, int outTime) {
        this.inTime = inTime;
        this.outTime = outTime;
    }
}
