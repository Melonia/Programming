package math2;

import java.util.Scanner;

public class N3009 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		int[][] point = new int[3][2];
		
		for(int i = 0; i < 3; i++)
			for(int j = 0; j < 2; j++)
				point[i][j] = scanner.nextInt();
		
		System.out.print(((point[0][0]==point[1][0])? 
				point[2][0] : (point[0][0]==point[2][0]?
						point[1][0]:point[0][0])) + " ");
		System.out.println((point[0][1]==point[1][1])? 
				point[2][1] : (point[0][1]==point[2][1]?
						point[1][1]:point[0][1]));
	}
}

/*
����
�� ���� �־����� ��, �࿡ ������ ���簢���� ����� ���ؼ� �ʿ��� �� ��° ���� ã�� ���α׷��� �ۼ��Ͻÿ�.

�Է�
�� ���� ��ǥ�� �� �ٿ� �ϳ��� �־�����. ��ǥ�� 1���� ũ�ų� ����, 1000���� �۰ų� ���� �����̴�.

���
���簢���� �� ��° ���� ��ǥ�� ����Ѵ�.
*/