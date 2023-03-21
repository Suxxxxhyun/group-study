import java.io.IOException;

public class Main1152_2 {

    public static void main(String args[])throws IOException{
    	int count = 0;
		int pre_str = 32;	// 공백을 의미한다.
		int str ;
		
		while(true) {
			// buffer를 사용하지 않고 원시 입력 형태로 문자 하나씩 읽어들이면서 읽어들인 문자가 공백인지 아닌지 count
			str = System.in.read();
			// 입력받은 문자가 공백일 때,
			if(str == 32) {
				// 이전의 문자가 공백이 아니면
				if(pre_str != 32) count++;
			}
			// 입력받은 문자가 개행일때 ('\n')
			else if(str == 10) {
				// 이전의 문자가 공백이 아니면
				if(pre_str != 32) count++;
				break;
			}
			pre_str = str;
		}
		System.out.println(count);
	}
    	
}