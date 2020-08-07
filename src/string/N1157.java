package string;

import java.util.Scanner;

public class N1157 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String s = scan.nextLine();
		int[] a = new int[26];
		int max = -1;
		int count = 0;
		int index = 0;
		
		s=s.toLowerCase(); //문자 개수를 파악하기 위해 소문자로 전부 변환
		
		//A의 개수를 a[0]번에 저장. B의 개수를 a[1]에 저장
		for(int i = 0; i < s.length(); i++) {
			a[s.charAt(i)-97]++;
		}
		
		/*
		 * for(int i = 0; i < 26; i++) {
			System.out.println(a[i]);
		   }
		*/
		
		//a배열에서 최댓값을 찾는다 그리고 그 인덱스를 입력한다.(인덱스가 곧 알파벳이므로)
		for(int i = 0; i < 26; i++) {
			if(max<a[i]) {
				max = a[i];
				index = i;
			}
		}
		
		//최댓값이 여러개인지 확인하는 작업
		for(int i = 0; i < 26; i++) {
			if(max == a[i]) count++;
		}
		
		if(count > 1) System.out.println("?");
		else System.out.println((char)(index+65)); //최댓값의 인덱스를 대문자로 변환하여 출력한다.
		
	}

}

/*
문제
알파벳 대소문자로 된 단어가 주어지면, 이 단어에서 가장 많이 사용된 알파벳이 무엇인지 알아내는 프로그램을 작성하시오. 단, 대문자와 소문자를 구분하지 않는다.

입력
첫째 줄에 알파벳 대소문자로 이루어진 단어가 주어진다. 주어지는 단어의 길이는 1,000,000을 넘지 않는다.

출력
첫째 줄에 이 단어에서 가장 많이 사용된 알파벳을 대문자로 출력한다. 단, 가장 많이 사용된 알파벳이 여러 개 존재하는 경우에는 ?를 출력한다.
*/