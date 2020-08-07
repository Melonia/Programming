package practice1;

import java.util.Scanner;

public class N2523 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int number = scan.nextInt();
		
		for(int i = number - 1;i > -number; i-- ) {
			for(int j = number - Abs.abs(i); j > 0; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}

//절댓값을 출력하는 클래스
class Abs{
	static int abs(int number) {
		if(number<0) return -number;
		else return number;
	}
}
/*
문제
예제를 보고 규칙을 유추한 뒤에 별을 찍어 보세요.

입력
첫째 줄에 N(1 ≤ N ≤ 100)이 주어진다.

출력
첫째 줄부터 2×N-1번째 줄까지 차례대로 별을 출력한다.
*/