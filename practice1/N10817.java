package practice1;

import java.util.Scanner;

public class N10817 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		I_D input = new I_D(); //세 수를 입력 받는 객체
		C_D cal = new C_D(input); //2번째 큰 정수를 계산하는 객체에 세 수가 입력된 객체를 전달.
		cal.secNumber(); //두 번째 정수를 리턴하는 메소드 호출	
	}
}

//data를 넣는 클래스
class I_D{
	Scanner scan = new Scanner(System.in);
	
	int a,b,c;
	
	I_D(){
		this.a = scan.nextInt();
		this.b = scan.nextInt();
		this.c = scan.nextInt();
	}
}

//
class C_D{
	I_D input;
	int second_number;
	
	C_D(I_D input){
		this.input = input;
		this.second_number = this.calculation(input.a, input.b, input.c);
	}
	
	int calculation(int a,int b,int c) {
		if((a<=b&&b<=c)||(c<=b&&b<=a)) return b;
		else if((b<=a&&a<=c)||(c<=a&&a<=b)) return a;
		else return c;
	}
	
	void secNumber() {
		System.out.println(this.second_number);
	}
}
/*
문제
세 정수 A, B, C가 주어진다. 이때, 두 번째로 큰 정수를 출력하는 프로그램을 작성하시오. 

입력
첫째 줄에 세 정수 A, B, C가 공백으로 구분되어 주어진다. (1 ≤ A, B, C ≤ 100)

출력
두 번째로 큰 정수를 출력한다.
*/