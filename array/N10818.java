package array;

import java.util.Scanner;

public class N10818 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int score[];
		int number = scan.nextInt();
		score = new int[number];
		
		for(int i = 0; i< number; i++) {
			score[i] = scan.nextInt();
		}
		
		System.out.println(Min.min(score) + " " + Max.max(score));
	}
}
class Max {
	
	static int max(int ... values) {
		int max = -1000000;
	
		for(int i : values) {
			if(max<i) max =i;
		}
		
		return max;
	}
	
}

class Min {
	
		static int min(int ... values) {
			int min = 1000000;
		
			for(int i : values) {
				if(min > i) min = i;
			}
			
			return min;
		}

}
/*
����
N���� ������ �־�����. �̶�, �ּڰ��� �ִ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� ������ ���� N (1 �� N �� 1,000,000)�� �־�����. ��° �ٿ��� N���� ������ �������� �����ؼ� �־�����. ��� ������ -1,000,000���� ũ�ų� ����, 1,000,000���� �۰ų� ���� �����̴�.

���
ù° �ٿ� �־��� ���� N���� �ּڰ��� �ִ��� �������� ������ ����Ѵ�.
*/