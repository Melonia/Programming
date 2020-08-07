package practice1;

import java.util.Scanner;

public class N10996 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int number = scan.nextInt();
		
		for(int i = 0; i < number; i++) {
			int count = 0;	
			
			while(true) {
			    System.out.print("*");count++;
			    if(count == number) break;
		        System.out.print(" ");count++;
		        if(count == number) break;
			}
			
			System.out.println();
			count = 0;
			
			while(true) {
			    System.out.print(" ");count++;
				if(count == number) break;
			    System.out.print("*");count++;
			    if(count == number) break;
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
첫째 줄부터 차례대로 별을 출력한다.
*/