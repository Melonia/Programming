package practice1;

import java.util.Scanner;

public class N2446 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int number;
		number = scan.nextInt();
		
		for(int i = number;i > -number-1;i--) {
			boolean value = false;
			if(i==0||i==-1) continue;
			for(int j = 0;j < 2*Math.abs(i) - 1;j++) {
				if(value == false) {
					for(int k = 0;k < number-Math.abs(i);k++) {
						System.out.print(" ");
						value = true;
					}
				}
				System.out.print("*");	
			}
			System.out.println();	
		}	
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