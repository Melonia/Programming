package array;

import java.util.Scanner;

public class N4344 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int testCase;
		int count;
		Scanner scan = new Scanner(System.in);
		testCase = scan.nextInt();
		
		for(int i =0;i<testCase;i++) {
			int testCase2 = scan.nextInt();
			int[] student = new int[testCase2];
			
			for(int k = 0; k < testCase2; k++) {
				student[k] = scan.nextInt();
			}
			
			double average = Operation1.average(student);
			count = 0;
			
			for(int j = 0; j < student.length; j++) {
				if(student[j] > average) {
					count++;
				}
			}
			
			System.out.printf("%.3f",(double)count/student.length*100);
			System.out.println("%");
		}
	
	}

}


class Operation1{

	static double average(int ...values) {
		
		return (double)sum(values)/values.length;
		
	}
	
	static int sum(int ...values) {
		
		int sum = 0;
		
		for(int value : values) {
			sum += value;
		}
		
		return sum;
		
	}

	
}



/*
����
���л� ��������� 90%�� �ڽ��� �ݿ��� ����� �Ѵ´ٰ� �����Ѵ�. ����� �׵鿡�� ���� ������ �˷���� �Ѵ�.

�Է�
ù° �ٿ��� �׽�Ʈ ���̽��� ���� C�� �־�����.

��° �ٺ��� �� �׽�Ʈ ���̽����� �л��� �� N(1 �� N �� 1000, N�� ����)�� ù ���� �־�����, �̾ N���� ������ �־�����. ������ 0���� ũ�ų� ����, 100���� �۰ų� ���� �����̴�.

���
�� ���̽����� �� �پ� ����� �Ѵ� �л����� ������ �ݿø��Ͽ� �Ҽ��� ��° �ڸ����� ����Ѵ�.
*/