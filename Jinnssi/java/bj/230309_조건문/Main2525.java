import java.util.Scanner;

public class Main2525 {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        // 현재 시각 
        int A = sc.nextInt();// 시
        int B = sc.nextInt();// 분
        // 필요한 시간(분 단위)
        int C = sc.nextInt();

        if(A==0) A=24;
        int result = (A*60+B)+C;// 분 
        
        A = result/60;
        B = result%60; 
        
        // 24시 일경우 바꿔주기
        // 24시 이상일경우 
        if(A==24) A = 0;
        else if(A>24) A = A%24;
        
        System.out.println(A+" "+B);
        sc.close();

    }
}