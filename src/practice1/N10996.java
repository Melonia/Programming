package practice1;

import java.util.Scanner;

public class N10996 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int number = scan.nextInt();
		
		for(int i = 0; i < number; i++) {
			int count = 0;	
			
			while(true) {
			    System.out.print("*");count++;
			    if(count == number) break;
		        System.out.print(" ");count++;
		        if(count == number) break;
			}
			
			System.out.println();
			count = 0;
			
			while(true) {
			    System.out.print(" ");count++;
				if(count == number) break;
			    System.out.print("*");count++;
			    if(count == number) break;
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
ù° �ٺ��� ���ʴ�� ���� ����Ѵ�.
*/