package practice1;

import java.util.Scanner;

public class N2446 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int number;
		number = scan.nextInt();
		
		for(int i = number;i > -number-1;i--) {
			boolean value = false;
			if(i==0||i==-1) continue;
			for(int j = 0;j < 2*Math.abs(i) - 1;j++) {
				if(value == false) {
					for(int k = 0;k < number-Math.abs(i);k++) {
						System.out.print(" ");
						value = true;
					}
				}
				System.out.print("*");	
			}
			System.out.println();	
		}	
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