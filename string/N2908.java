package string;

import java.util.Scanner;

public class N2908 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		
		// ���� 2���� �Է¹޴� ����
		int old_num1 = scan.nextInt();
		int old_num2 = scan.nextInt();
		
		// ���� 2���� ���ڿ��� ��ȯ
		String old_str1 = Integer.toString(old_num1);
		String old_str2 = Integer.toString(old_num2);
		
		// ���ڿ��� �Ųٷ� �б� ���� ���ο� ���ڿ� ����
		String new_str1 = "";
		String new_str2 = "";
		
		// ���� ���ڿ��� �Ųٷ� �о� ���ο� ���ڿ��� ���ʴ�� ����
		for(int i = 2; i >=0 ; i--) {
			new_str1 += old_str1.charAt(i);
			new_str2 += old_str2.charAt(i);
		}
		
		// ���ο� ���ڿ��� ������ ��ȯ
		int new_num1 = Integer.parseInt(new_str1);
		int new_num2 = Integer.parseInt(new_str2);
		
		// ũ�� ��
		if(new_num1<new_num2) System.out.println(new_num2);
		else System.out.println(new_num1);
		
	}

}

/*
����
������� ���� ����� ������ ���� ���Ѵ�. ����� ���ڸ� �дµ� ������ �ִ�. �̷��� ������ ���ϴ� ����� ���ؼ� ����̴� ���� ũ�⸦ ���ϴ� ������ ���־���. ����̴� �� �ڸ� �� �� ���� ĥ�ǿ� ���־���. �� ������ ũ�Ⱑ ū ���� ���غ���� �ߴ�.

����� ���� �ٸ� ����� �ٸ��� �Ųٷ� �д´�. ���� ���, 734�� 893�� ĥ�ǿ� �����ٸ�, ����� �� ���� 437�� 398�� �д´�. ����, ����� �� ���� ū ���� 437�� ū ����� ���� ���̴�.

�� ���� �־����� ��, ����� ����� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� ����̰� ĥ�ǿ� ���� �� �� A�� B�� �־�����. �� ���� ���� ���� �� �ڸ� ���̸�, 0�� ���ԵǾ� ���� �ʴ�.

���
ù° �ٿ� ����� ����� ����Ѵ�.
*/