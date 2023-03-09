import java.util.Scanner;

public class Main9498 {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int x= sc.nextInt();
        String y="";
        
        if(90<=x&&x<=100) y="A";
        else if(80<=x&&x<=89) y="B";
        else if(70<=x&&x<=79) y="C";
        else if(60<=x&&x<=69) y="D";
        else y="F";
        
        System.out.println(y);
        sc.close();

    }
}