package array;

import java.util.Scanner;

public class N2577 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int[] values = new int[3];	
		
		for(int i = 0; i < 3; i++) {
			values[i] = scan.nextInt();
		}
		
		int number = ArrayMul.input(values);

		int[] count = new int[10];
		
		while(number/10 != 0){
			count[number%10]++;
			number /= 10;
		} 
		count[number]++;
		
		for( int i = 0; i < 10; i++) {
			System.out.println(count[i]);
		}
	
	}

}

class ArrayMul {
	
	static int input(int ...values) {
		int sum = 1;
		
		for(int value : values) {
			sum *= value;
		}
		
		return sum;
	
	}

}


/*
����
�� ���� �ڿ��� A, B, C�� �־��� �� A��B��C�� ����� ����� 0���� 9���� ������ ���ڰ� �� ���� ���������� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

���� ��� A = 150, B = 266, C = 427 �̶�� 

A �� B �� C = 150 �� 266 �� 427 = 17037300 �� �ǰ�, 

����� ��� 17037300 ���� 0�� 3��, 1�� 1��, 3�� 2��, 7�� 2�� ������.

�Է�
ù° �ٿ� A, ��° �ٿ� B, ��° �ٿ� C�� �־�����. A, B, C�� ��� 100���� ���ų� ũ��, 1,000���� ���� �ڿ����̴�.

���
ù° �ٿ��� A��B��C�� ����� 0 �� �� �� �������� ����Ѵ�. ���������� ��° �ٺ��� �� ��° �ٱ��� A��B��C�� ����� 1���� 9������ ���ڰ� ���� �� �� �������� ���ʷ� �� �ٿ� �ϳ��� ����Ѵ�.
*/