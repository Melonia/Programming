package math1;

import java.util.Scanner;

public class N1193 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int k;
		int count = 0;
		int number;

		Scanner scan = new Scanner(System.in);

		number = scan.nextInt();

		outer: for (int i = 1;; i++) {
			
			k = i;
			
			for (int j = 1; j <= i; j++) {
				count++;
				if (i % 2 == 0) {
					if (count == number) {
						System.out.println(j + "/" + k);
						break outer;
					}

				} else {
					if (count == number) {
						System.out.println(k + "/" + j);
						break outer;
					}

				}

				k--;
			}

		}

	}

}

/*
문제
이와 같이 나열된 분수들을 1/1 -> 1/2 -> 2/1 -> 3/1 -> 2/2 -> … 과 같은 지그재그 순서로 차례대로 1번, 2번, 3번, 4번, 5번, … 분수라고 하자.

X가 주어졌을 때, X번째 분수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 X(1 ≤ X ≤ 10,000,000)가 주어진다.

출력
첫째 줄에 분수를 출력한다.
*/