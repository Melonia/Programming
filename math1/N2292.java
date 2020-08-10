package math1;

import java.util.Scanner;

public class N2292 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);

		int number = scan.nextInt(); //������ ���� ��ȣ

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
	
	
	//���ڵ��� �迭�� �Է¹޾� �� ���ڵ��� �ִ��� �����ϴ� �޼ҵ�
	static int max(int ... values) {
		int max = -(exp(2,30)*2);
		
		for(int value : values) {
			if(max < value) max = value;
		}
		
		return max;
	}
	
	//base(��)�� exponent(����)�� �Է¹޾� exponentiation�� �����ϴ� �޼ҵ�
	static int exp(int base, int exponent) { 
		
		int exponentiation = 1; //�ŵ�����
		
		for(int i = 0; i < exponent; i++) {
			exponentiation *= base;
		}
		
		return exponentiation;

	}
	
}


/*
����
���� �׸�(���� ����)�� ���� ���������� �̷���� ������ �ִ�. �׸����� ���� �ٿ� ���� �߾��� �� 1���� �����ؼ� �̿��ϴ� �濡 ���ư��鼭 1�� �����ϴ� ��ȣ�� �ּҷ� �ű� �� �ִ�. ���� N�� �־����� ��, ������ �߾� 1���� N�� ����� �ּ� ������ ���� ������ �� �� �� ���� ���� ����������(���۰� ���� �����Ͽ�)�� ����ϴ� ���α׷��� �ۼ��Ͻÿ�. ���� ���, 13������ 3��, 58������ 5���� ������.

�Է�
ù° �ٿ� N(1 �� N �� 1,000,000,000)�� �־�����.

���
�Է����� �־��� ����� �ּ� ������ ���� ������ �� �� �� ���� ���� �������� ����Ѵ�.
*/