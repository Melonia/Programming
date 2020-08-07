package array;

import java.util.Scanner;

public class N3052 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		final int dividendAmount = 10;
		final int divisor = 42; // 제수 <-> 피제수
		
		int[] remainderCounter = new int[divisor]; // 나머지가 index인 숫자의 개수 배열
		int[] dividendArray = new int[dividendAmount]; // 42로 나누려고 입력한 숫자를 대입할 배열
		
		int count = 0;
		
		Scanner scan = new Scanner(System.in);
		
		//number 개의 숫자를 배열에 입력
		for(int i = 0; i < dividendAmount; i++) {
			dividendArray[i] = scan.nextInt();
		}
		
		//number 를 순회하며 42로 나눈 나머지를 나머지 배열에 저장
		for(int i = 0; i < dividendAmount; i++) {
			remainderCounter[dividendArray[i]%42]++;
		}
		
		//나머지 배열을 순회하며 나머지가 존재하면 갯수와 관계없이 한 개로 counting...
		for(int i = 0; i < remainderCounter.length; i++) {
			if( remainderCounter[i] > 0) {
				count++;
			}
		}
		
		System.out.println(count);
	}
}
/*
문제
두 자연수 A와 B가 있을 때, A%B는 A를 B로 나눈 나머지 이다. 예를 들어, 7, 14, 27, 38을 3으로 나눈 나머지는 1, 2, 0, 2이다. 

수 10개를 입력받은 뒤, 이를 42로 나눈 나머지를 구한다. 그 다음 서로 다른 값이 몇 개 있는지 출력하는 프로그램을 작성하시오.

입력
첫째 줄부터 열번째 줄 까지 숫자가 한 줄에 하나씩 주어진다. 이 숫자는 1,000보다 작거나 같고, 음이 아닌 정수이다.

출력
첫째 줄에, 42로 나누었을 때, 서로 다른 나머지가 몇 개 있는지 출력한다.
*/