package recursion;

import java.util.Scanner;

public class N10872 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		Fact f = new Fact();
		System.out.println(f.factorial(n));
	}

}
class Fact{
	int n;
	int factorial(int n) {
		if(n == 0 || n == 1) return 1;
		else return n*factorial(n-1);
	}
}

/*
����
0���� ũ�ų� ���� ���� N�� �־�����. �̶�, N!�� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� ���� N(0 �� N �� 12)�� �־�����.

���
ù° �ٿ� N!�� ����Ѵ�.
*/