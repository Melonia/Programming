package math1;

import java.util.Scanner;

public class N2292 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);

		int number = scan.nextInt(); //목적지 방의 번호

		int i = 1;
		int criteria = 1; 

		while (true) {

			if (number <= criteria) {
				System.out.println(i);
				break;
			}

			i++;
			criteria = 3*Operation.exp(i, 2)-3*i+1;

		}

	}

}

class Operation{
	
	static double formula_1(int number1,int number2) {
		
		return (double)number1/number2*100;
	
	}
	
	static double average(int ...values) {
		
		return (double)sum(values)/values.length;
		
	}
	
	static double average(double ...values) {
		
		return sum(values)/values.length;
	
	}
	
	static int sum(int ...values) {
		
		int sum = 0;
		
		for(int value : values) {
			sum += value;
		}
		
		return sum;
		
	}
	
	static double sum(double ...values) {
		
		double sum = 0;
		
		for(double value : values) {
			sum += value;
		}
	
		return sum;
	
	}
	
	
	//숫자들의 배열을 입력받아 그 숫자들의 최댓값을 리턴하는 메소드
	static int max(int ... values) {
		int max = -(exp(2,30)*2);
		
		for(int value : values) {
			if(max < value) max = value;
		}
		
		return max;
	}
	
	//base(밑)와 exponent(지수)를 입력받아 exponentiation을 리턴하는 메소드
	static int exp(int base, int exponent) { 
		
		int exponentiation = 1; //거듭제곱
		
		for(int i = 0; i < exponent; i++) {
			exponentiation *= base;
		}
		
		return exponentiation;

	}
	
}


/*
문제
위의 그림(백준 참고)과 같이 육각형으로 이루어진 벌집이 있다. 그림에서 보는 바와 같이 중앙의 방 1부터 시작해서 이웃하는 방에 돌아가면서 1씩 증가하는 번호를 주소로 매길 수 있다. 숫자 N이 주어졌을 때, 벌집의 중앙 1에서 N번 방까지 최소 개수의 방을 지나서 갈 때 몇 개의 방을 지나가는지(시작과 끝을 포함하여)를 계산하는 프로그램을 작성하시오. 예를 들면, 13까지는 3개, 58까지는 5개를 지난다.

입력
첫째 줄에 N(1 ≤ N ≤ 1,000,000,000)이 주어진다.

출력
입력으로 주어진 방까지 최소 개수의 방을 지나서 갈 때 몇 개의 방을 지나는지 출력한다.
*/