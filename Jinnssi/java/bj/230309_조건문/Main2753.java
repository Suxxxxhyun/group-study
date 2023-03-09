import java.util.Scanner;

public class Main2753 {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int year= sc.nextInt();
        int x=0;
        
        // 4의 배수이면서 100배수가 아님 또는 400배수   
        if( (year%4==0 && year%100!=0) || year%400==0 ) x=1;
        else x=0;
        
        System.out.println(x);
        sc.close();

    }
}