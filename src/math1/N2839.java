package math1;

import java.util.*;

public class N2839 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int count = 0;

		if (n % 5 == 0) {
			count = n / 5;
			System.out.println(count);
		} 
		else  {
			
			while (true) {
				if (n % 3 == 0 && n < 10) {
					count += n / 3;
					System.out.println(count);
					break;
				}
				n = n - 3;
				count++;
				if (n % 5 == 0 && n > 0) {
					count = count + n / 5;
					System.out.println(count);
					break;

				} else if (n < 0) {
					System.out.println(-1);
					break;
				}
			}
			
			
		}

	}
}
/*
����
����̴� ���� �������忡�� ������ ����ϰ� �ִ�. ����̴� ���� �������Կ� ������ ��Ȯ�ϰ� Nų�α׷��� ����ؾ� �Ѵ�. �������忡�� ����� ������ ������ ����� �ִ�. ������ 3ų�α׷� ������ 5ų�α׷� ������ �ִ�.

����̴� ������ ������, �ִ��� ���� ������ ��� ������ �Ѵ�. ���� ���, 18ų�α׷� ������ ����ؾ� �� ��, 3ų�α׷� ���� 6���� �������� ������, 5ų�α׷� 3���� 3ų�α׷� 1���� ����ϸ�, �� ���� ������ ������ ����� �� �ִ�.

����̰� ������ ��Ȯ�ϰ� Nų�α׷� ����ؾ� �� ��, ���� �� ���� �������� �Ǵ��� �� ���� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� N�� �־�����. (3 �� N �� 5000)

���
����̰� ����ϴ� ������ �ּ� ������ ����Ѵ�. ����, ��Ȯ�ϰ� Nų�α׷��� ���� �� ���ٸ� -1�� ����Ѵ�.
*/