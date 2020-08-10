package math2;

import java.util.ArrayList;
import java.util.Scanner;

public class N1978 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> array = new ArrayList<Integer>();

		for (int i = 1; i <= 1000; i++)
			array.add(i);

		array.remove(0);
		for (int i = 0; i < 1000; i++) {
			for (int j = 0; j < array.size(); j++)
				if (array.get(j) % (2 + i) == 0 && array.get(j) != (2 + i))
					array.remove(j);
		}

		Scanner scanner = new Scanner(System.in);
		int testCase = scanner.nextInt();
		int[] number = new int[testCase];
		for (int i = 0; i < testCase; i++) {
			number[i] = scanner.nextInt();
		}
		int count = 0;
		for (int i = 0; i < testCase; i++) {
			for (int j = 0; j < array.size(); j++) {
				if (number[i] == array.get(j))
					count++;
			}
		}
		System.out.println(count);

	}

}

/*
문제
주어진 수 N개 중에서 소수가 몇 개인지 찾아서 출력하는 프로그램을 작성하시오.

입력
첫 줄에 수의 개수 N이 주어진다. N은 100이하이다. 다음으로 N개의 수가 주어지는데 수는 1,000 이하의 자연수이다.

출력
주어진 수들 중 소수의 개수를 출력한다.
*/