package string;

import java.util.Scanner;

public class N2908 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		
		// 숫자 2개를 입력받는 구간
		int old_num1 = scan.nextInt();
		int old_num2 = scan.nextInt();
		
		// 숫자 2개를 문자열로 변환
		String old_str1 = Integer.toString(old_num1);
		String old_str2 = Integer.toString(old_num2);
		
		// 문자열을 거꾸로 읽기 위해 새로운 문자열 선언
		String new_str1 = "";
		String new_str2 = "";
		
		// 원래 문자열을 거꾸로 읽어 새로운 문자열에 차례대로 저장
		for(int i = 2; i >=0 ; i--) {
			new_str1 += old_str1.charAt(i);
			new_str2 += old_str2.charAt(i);
		}
		
		// 새로운 문자열을 정수로 변환
		int new_num1 = Integer.parseInt(new_str1);
		int new_num2 = Integer.parseInt(new_str2);
		
		// 크기 비교
		if(new_num1<new_num2) System.out.println(new_num2);
		else System.out.println(new_num1);
		
	}

}

/*
문제
상근이의 동생 상수는 수학을 정말 못한다. 상수는 숫자를 읽는데 문제가 있다. 이렇게 수학을 못하는 상수를 위해서 상근이는 수의 크기를 비교하는 문제를 내주었다. 상근이는 세 자리 수 두 개를 칠판에 써주었다. 그 다음에 크기가 큰 수를 말해보라고 했다.

상수는 수를 다른 사람과 다르게 거꾸로 읽는다. 예를 들어, 734와 893을 칠판에 적었다면, 상수는 이 수를 437과 398로 읽는다. 따라서, 상수는 두 수중 큰 수인 437을 큰 수라고 말할 것이다.

두 수가 주어졌을 때, 상수의 대답을 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 상근이가 칠판에 적은 두 수 A와 B가 주어진다. 두 수는 같지 않은 세 자리 수이며, 0이 포함되어 있지 않다.

출력
첫째 줄에 상수의 대답을 출력한다.
*/