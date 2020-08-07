package brute_force;

import java.util.Scanner;

public class N7568 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int testCase = scan.nextInt();
		int[] x = new int[testCase];
		int[] y = new int[testCase];
		int[] z = new int[testCase];
		for (int i = 0; i < testCase; i++) {
			x[i] = scan.nextInt();
			y[i] = scan.nextInt();
		}

		for (int i = 0; i < testCase; i++) {
			int count = 0;
			for (int j = 0; j < testCase; j++) {
				if (i == j)
					continue;
				if (x[i] < x[j] && y[i] < y[j])
					count++;
			}
			z[i] = count + 1;
		}
		for(int i = 0; i < testCase; i++)
			System.out.print(z[i]+" ");

	}

}

/*
����
�츮�� ����� ��ġ�� Ű�� ������, �� �� ���� ������ ǥ���Ͽ� �� ����� �Űܺ����� �Ѵ�. � ����� �����԰� x kg�̰� Ű�� y cm��� �� ����� ��ġ�� (x,y)�� ǥ�õȴ�. �� ��� A �� B�� ��ġ�� ���� (x,y), (p,q)��� �� �� x>p �׸��� y>q �̶�� �츮�� A�� ��ġ�� B�� ��ġ���� "�� ũ��"�� ���Ѵ�. ���� ��� � A, B �� ����� ��ġ�� ���� (56,177), (45,165) ��� �Ѵٸ� A�� ��ġ�� B���� ū ���� �ȴ�. �׷��� ���� �ٸ� ��ġ���� ũ�⸦ ���� �� ���� ��쵵 �ִ�. ���� ��� �� ��� C�� D�� ��ġ�� ���� (45, 181), (55,173)�̶�� �����Դ� D�� C���� �� ���̰�, Ű�� C�� �� ũ�Ƿ�, "��ġ"�θ� �� �� C�� D�� ������ ���溸�� �� ũ�ٰ� ���� �� ����.

N���� ���ܿ��� �� ����� ��ġ ����� �ڽź��� �� "ū ��ġ"�� ����� ���� ��������. ���� �ڽź��� �� ū ��ġ�� ����� k���̶�� �� ����� ��ġ ����� k+1�� �ȴ�. �̷��� ����� �����ϸ� ���� ��ġ ����� ���� ����� ���� ���� �����ϴ�. �Ʒ��� 5������ �̷���� ���ܿ��� �� ����� ��ġ�� �� ����� ǥ�õ� ǥ�̴�.

�̸�	<������, Ű>	��ġ ���
A	<55, 185>	2
B	<58, 183>	2
C	<88, 186>	1
D	<60, 175>	2
E	<46, 155>	5
�� ǥ���� C���� �� ū ��ġ�� ����� �����Ƿ� C�� 1���� �ȴ�. �׸��� A, B, D ������ ��ġ���� ū ����� C���̹Ƿ� �̵��� ��� 2���� �ȴ�. �׸��� E���� ū ��ġ�� A, B, C, D �̷��� 4���̹Ƿ� E�� ��ġ�� 5���� �ȴ�. �� ��쿡 3��� 4���� �������� �ʴ´�. �������� �л� N���� �����Կ� Ű�� ��� �Է��� �о �� ����� ��ġ ����� ����Ͽ� ����ؾ� �Ѵ�.

�Է�
ù �ٿ��� ��ü ����� �� N�� �־�����. �׸��� �̾����� N���� �ٿ��� �� ����� �����Կ� Ű�� ��Ÿ���� ���� ���� x�� y�� �ϳ��� ������ �ΰ� ���� ��Ÿ����. ��, 2 �� N �� 50, 10 �� x,y �� 200 �̴�.

���
�������� �Է¿� ������ ����� ��ġ ����� ���ؼ� �� ������� ù �ٿ� ����ؾ� �Ѵ�. ��, �� ��ġ ����� ���鹮�ڷ� �и��Ǿ�� �Ѵ�.
*/