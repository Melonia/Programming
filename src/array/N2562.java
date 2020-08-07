package array;

import java.util.Scanner;

public class N2562 {
	static final int number = 9; 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		int[] values = new int[number];
		
		for(int i = 0; i < number; i++) {
			values[i] = scan.nextInt();
		}
		
		System.out.println(Max1.max(values));
		System.out.println(Index_Find.find(values,Max.max(values)));
	}
}
class Index_Find {
	static int find(int[] values,int num) {
		int i;
		
		for(i = 0; i < values.length; i++) {
			if(values[i] == num) break;
		}
		
		return (i + 1);
	}
}

class Max1 {
	
	static int max(int ... values) {
		int max = -1000000;
	
		for(int i : values) {
			if(max < i) max =i;
		}
		
		return max;
	}

}

/*
����
9���� ���� �ٸ� �ڿ����� �־��� ��, �̵� �� �ִ��� ã�� �� �ִ��� �� ��° �������� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

���� ���, ���� �ٸ� 9���� �ڿ���

3, 29, 38, 12, 57, 74, 40, 85, 61

�� �־�����, �̵� �� �ִ��� 85�̰�, �� ���� 8��° ���̴�.

�Է�
ù ° �ٺ��� ��ȩ ��° �ٱ��� �� �ٿ� �ϳ��� �ڿ����� �־�����. �־����� �ڿ����� 100 ���� �۴�.

���
ù° �ٿ� �ִ��� ����ϰ�, ��° �ٿ� �ִ��� �� ��° �������� ����Ѵ�.
*/