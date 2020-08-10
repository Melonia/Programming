package brute_force;

import java.util.Scanner;

public class N2231 {

	static int exp(int x, int n) {
		int sum = 1;
		for (int i = 0; i < n; i++)
			sum *= x;
		return sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);

		int number = scan.nextInt();

		int count = 0;
		for (int i = 0; i < 6; i++) {

			if (number / exp(10, i) > 0)
				count++;
			else
				break;
		}

		for (int i = number - (count * 10); i < number; i++) {

			int sum = 0;
			int j = i;

			while (true) {
				sum += j % 10;
				j /= 10;
				if (j <= 0) {
					break;
				}
			}

			if (number == sum + i) {
				System.out.println(i);
				return;
			}

		}
		System.out.println(0);
	}

}

/*
문제
어떤 자연수 N이 있을 때, 그 자연수 N의 분해합은 N과 N을 이루는 각 자리수의 합을 의미한다. 어떤 자연수 M의 분해합이 N인 경우, M을 N의 생성자라 한다. 예를 들어, 245의 분해합은 256(=245+2+4+5)이 된다. 따라서 245는 256의 생성자가 된다. 물론, 어떤 자연수의 경우에는 생성자가 없을 수도 있다. 반대로, 생성자가 여러 개인 자연수도 있을 수 있다.

자연수 N이 주어졌을 때, N의 가장 작은 생성자를 구해내는 프로그램을 작성하시오.

입력
첫째 줄에 자연수 N(1 ≤ N ≤ 1,000,000)이 주어진다.

출력
첫째 줄에 답을 출력한다. 생성자가 없는 경우에는 0을 출력한다.
*/