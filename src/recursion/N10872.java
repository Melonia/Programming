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
문제
0보다 크거나 같은 정수 N이 주어진다. 이때, N!을 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 정수 N(0 ≤ N ≤ 12)가 주어진다.

출력
첫째 줄에 N!을 출력한다.
*/