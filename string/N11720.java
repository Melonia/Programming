package string;

import java.util.Scanner;

public class N11720 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int size = scan.nextInt();
		scan.nextLine(); //중요. nextInt는 엔터를 입력받지 않으므로 다음에 nextLine이 오면 거기에서 엔터를 입력받음. 따라서 nextLine을 통해 엔터를 제거한다.
		
		String s = scan.nextLine(); //입력받은 수를 문자열로 입력
		String[] s2 = new String[size]; //입력받은 문자열을 문자하나씩 문자열배열에 저장
		int[] a = new int[size]; //문자열 배열에 저장된 문자를 정수로 변환 후 입력
		
		
		//문자열 분리
		for(int i = 0; i < size; i++) {
			s2[i] = s.substring(i,i+1); //문자열을 분리하는 방법
		}
		
		//문자->정수
		for(int i = 0; i < size; i++) {
			a[i] = Integer.parseInt(s2[i]); //문자를 정수화하는 방법
		}

		int sum = Operation.sum(a);
		System.out.println(sum);
		
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
N개의 숫자가 공백 없이 쓰여있다. 이 숫자를 모두 합해서 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 숫자의 개수 N (1 ≤ N ≤ 100)이 주어진다. 둘째 줄에 숫자 N개가 공백없이 주어진다.

출력
입력으로 주어진 숫자 N개의 합을 출력한다.
*/