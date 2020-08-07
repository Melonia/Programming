package brute_force;

import java.util.Scanner;

public class N1018 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);

		int x, y;

		x = scan.nextInt();
		y = scan.nextInt();
		scan.nextLine();
		String[] s = new String[x];

		for (int i = 0; i < x; i++) {
			s[i] = scan.nextLine();
		}

		char[] str = new char[8];
		char[] str2 = new char[8];

		for (int i = 0; i < 8; i++) {
			if (i % 2 == 0) {
				str[i] = 'W';
				str2[i] = 'B';
			} else {
				str[i] = 'B';
				str2[i] = 'W';
			}
		}
		int count = 0;
		int min = 32;
		for (int a = 0; a + 8 <= x; a++)
			for (int b = 0; b + 8 <= y; b++) {
				for (int i = a; i < a + 8; i++) {
					if (i % 2 == 0) {
						for (int j = b; j < b + 8; j++) {
							if (str[j - b] != s[i].charAt(j))
								count++;

						}
					} else {
						for (int j = b; j < b + 8; j++) {
							if (str2[j - b] != s[i].charAt(j))
								count++;

						}
					}
				}
                
                if(count>32) count = 64-count;
				min = Math.min(min, count);
				count = 0;
                
			}
        
		System.out.println(min);
	}
}

/*
����
�����̴� �ڽ��� ���ÿ��� MN���� ���� ���簢������ �������� �ִ� M*N ũ���� ���带 ã�Ҵ�. � ���簢���� ���������� ĥ���� �ְ�, �������� ������� ĥ���� �ִ�. �����̴� �� ���带 �߶� 8*8 ũ���� ü�������� ������� �Ѵ�.

ü������ �������� ����� �����Ƽ� ĥ���� �־�� �Ѵ�. ��ü������, �� ĭ�� �������� ��� �� �ϳ��� ��ĥ�Ǿ� �ְ�, ���� �����ϴ� �� ���� �簢���� �ٸ� ������ ĥ���� �־�� �Ѵ�. ���� �� ���Ǹ� ������ ü������ ��ĥ�ϴ� ���� �� �������̴�. �ϳ��� �� ���� �� ĭ�� ����� ���, �ϳ��� �������� ����̴�.

���尡 ü����ó�� ĥ���� �ִٴ� ������ ���, �����̴� 8*8 ũ���� ü�������� �߶� �Ŀ� �� ���� ���簢���� �ٽ� ĥ�ؾ߰ڴٰ� �����ߴ�. �翬�� 8*8 ũ��� �ƹ������� ��� �ȴ�. �����̰� �ٽ� ĥ�ؾ� �ϴ� ���簢���� �ּ� ������ ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� N�� M�� �־�����. N�� M�� 8���� ũ�ų� ����, 50���� �۰ų� ���� �ڿ����̴�. ��° �ٺ��� N���� �ٿ��� ������ �� ���� ���°� �־�����. B�� �������̸�, W�� ����̴�.

���
ù° �ٿ� �����̰� �ٽ� ĥ�ؾ� �ϴ� ���簢�� ������ �ּڰ��� ����Ѵ�.
*/