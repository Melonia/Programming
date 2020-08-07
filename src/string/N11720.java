package string;

import java.util.Scanner;

public class N11720 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int size = scan.nextInt();
		scan.nextLine(); //�߿�. nextInt�� ���͸� �Է¹��� �����Ƿ� ������ nextLine�� ���� �ű⿡�� ���͸� �Է¹���. ���� nextLine�� ���� ���͸� �����Ѵ�.
		
		String s = scan.nextLine(); //�Է¹��� ���� ���ڿ��� �Է�
		String[] s2 = new String[size]; //�Է¹��� ���ڿ��� �����ϳ��� ���ڿ��迭�� ����
		int[] a = new int[size]; //���ڿ� �迭�� ����� ���ڸ� ������ ��ȯ �� �Է�
		
		
		//���ڿ� �и�
		for(int i = 0; i < size; i++) {
			s2[i] = s.substring(i,i+1); //���ڿ��� �и��ϴ� ���
		}
		
		//����->����
		for(int i = 0; i < size; i++) {
			a[i] = Integer.parseInt(s2[i]); //���ڸ� ����ȭ�ϴ� ���
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
N���� ���ڰ� ���� ���� �����ִ�. �� ���ڸ� ��� ���ؼ� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� ������ ���� N (1 �� N �� 100)�� �־�����. ��° �ٿ� ���� N���� ������� �־�����.

���
�Է����� �־��� ���� N���� ���� ����Ѵ�.
*/