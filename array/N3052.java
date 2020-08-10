package array;

import java.util.Scanner;

public class N3052 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		final int dividendAmount = 10;
		final int divisor = 42; // ���� <-> ������
		
		int[] remainderCounter = new int[divisor]; // �������� index�� ������ ���� �迭
		int[] dividendArray = new int[dividendAmount]; // 42�� �������� �Է��� ���ڸ� ������ �迭
		
		int count = 0;
		
		Scanner scan = new Scanner(System.in);
		
		//number ���� ���ڸ� �迭�� �Է�
		for(int i = 0; i < dividendAmount; i++) {
			dividendArray[i] = scan.nextInt();
		}
		
		//number �� ��ȸ�ϸ� 42�� ���� �������� ������ �迭�� ����
		for(int i = 0; i < dividendAmount; i++) {
			remainderCounter[dividendArray[i]%42]++;
		}
		
		//������ �迭�� ��ȸ�ϸ� �������� �����ϸ� ������ ������� �� ���� counting...
		for(int i = 0; i < remainderCounter.length; i++) {
			if( remainderCounter[i] > 0) {
				count++;
			}
		}
		
		System.out.println(count);
	}
}
/*
����
�� �ڿ��� A�� B�� ���� ��, A%B�� A�� B�� ���� ������ �̴�. ���� ���, 7, 14, 27, 38�� 3���� ���� �������� 1, 2, 0, 2�̴�. 

�� 10���� �Է¹��� ��, �̸� 42�� ���� �������� ���Ѵ�. �� ���� ���� �ٸ� ���� �� �� �ִ��� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٺ��� ����° �� ���� ���ڰ� �� �ٿ� �ϳ��� �־�����. �� ���ڴ� 1,000���� �۰ų� ����, ���� �ƴ� �����̴�.

���
ù° �ٿ�, 42�� �������� ��, ���� �ٸ� �������� �� �� �ִ��� ����Ѵ�.
*/