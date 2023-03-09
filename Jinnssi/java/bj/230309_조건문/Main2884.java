import java.util.Scanner;

public class Main2884 {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int H= sc.nextInt();
        int M= sc.nextInt();
        
        // H시 M분 에서 45분 빼기
        // H이 0일 경우 
        if(H==0) H=24;
        
        int result = (H*60+M)-45;// 분 
        
        int Rh = result/60;
        int Rm = result%60; 
        
        // 24시 일경우 바꿔주기
        if(Rh==24) Rh = 0;
        System.out.println(Rh+" "+Rm);
        sc.close();

    }
}