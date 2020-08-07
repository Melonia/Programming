package array;

import java.util.Scanner;

public class N1546 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] originalScore = TestCase.initialize();
		double[] modifiedScore = new double[originalScore.length];
		
		for(int i = 0; i < originalScore.length; i++) {
			modifiedScore[i] = Operation.formula_1(originalScore[i],Operation.max(originalScore));
		}
		System.out.println(Operation.average(modifiedScore));
	}

}

class TestCase {
	
	static int[] array;
	
	static int[] initialize() {
		
		Scanner scan = new Scanner(System.in);
		
		int testCase = scan.nextInt();
		
		array = new int[testCase];
		
		for(int i = 0; i < testCase; i++) {
			array[i] = scan.nextInt();
		}
		
		return array;
		
	}
	
}

class Operation{
	
	static double formula_1(int number1,int number2) {
		
		return (double)number1/number2*100;
	
	}
	
	static double average(double ...values) {
		
		return sum(values)/values.length;
	
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
�����̴� �⸻��縦 ���ƴ�. �����̴� ������ �����ؼ� ���� ��������� �ߴ�. �ϴ� �����̴� �ڱ� ���� �߿� �ִ��� �����. �� ���� M�̶�� �Ѵ�. �׸��� ���� ��� ������ ����/M*100���� ���ƴ�.

���� ���, �������� �ְ����� 70�̰�, ���������� 50�̾����� ���������� 50/70*100�� �Ǿ� 71.43���� �ȴ�.

�������� ������ ���� ������ ���� ������� ��, ���ο� ����� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� ���� �� ������ ���� N�� �־�����. �� ���� 1000���� �۰ų� ����. ��° �ٿ� �������� ���� ������ �־�����. �� ���� 100���� �۰ų� ���� ���� �ƴ� �����̰�, ��� �ϳ��� ���� 0���� ũ��.

���
ù° �ٿ� ���ο� ����� ����Ѵ�. ���� ����� ��°��� ������� �Ǵ� �������� 10-2 �����̸� �����̴�.
*/