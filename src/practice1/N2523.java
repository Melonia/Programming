package practice1;

import java.util.Scanner;

public class N2523 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int number = scan.nextInt();
		
		for(int i = number - 1;i > -number; i-- ) {
			for(int j = number - Abs.abs(i); j > 0; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}

//������ ����ϴ� Ŭ����
class Abs{
	static int abs(int number) {
		if(number<0) return -number;
		else return number;
	}
}
/*
����
������ ���� ��Ģ�� ������ �ڿ� ���� ��� ������.

�Է�
ù° �ٿ� N(1 �� N �� 100)�� �־�����.

���
ù° �ٺ��� 2��N-1��° �ٱ��� ���ʴ�� ���� ����Ѵ�.
*/