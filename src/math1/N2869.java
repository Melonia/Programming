package math1;

import java.util.Scanner;

public class N2869 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int climb;
		final int descend;
		final int height;

		Scanner scan = new Scanner(System.in);

		climb = scan.nextInt();
		descend = scan.nextInt();
		height = scan.nextInt();

		for (int i = 0; i < climb; i++) {
			if ((height - climb + i) % (climb - descend) == 0) {
				System.out.println((height - climb + i) / (climb - descend) + 1);
				break;
			}
		}

	}

}

/*
����
�� ���� �����̰� �ִ�. �� �����̴� ���̰� V������ ���� ���븦 �ö� ���̴�.

�����̴� ���� A���� �ö� �� �ִ�. ������, �㿡 ���� �ڴ� ���� B���� �̲�������. ��, ���� �ö� �Ŀ��� �̲������� �ʴ´�.

�����̰� ���� ���븦 ��� �ö󰡷���, ��ĥ�� �ɸ����� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� �� ���� A, B, V�� �������� ���еǾ �־�����. (1 �� B < A �� V �� 1,000,000,000)

���
ù° �ٿ� �����̰� ���� ���븦 ��� �ö󰡴µ� ��ĥ�� �ɸ����� ����Ѵ�.
*/