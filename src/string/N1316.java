package string;

import java.util.Scanner;

public class N1316 {

	public static void main(String[] argArray) {
		// TODO Auto-generated method Arraytub
		Scanner scan = new Scanner(System.in);
		// System.out.print("문자열 개수를 입력: ");
		int testCase = scan.nextInt();
		scan.nextLine();
		int i = 0;

		int count = 0;
		while (i < testCase) {
			
			String Array = scan.nextLine();
			String[] cmp = new String[Array.length()];
			char cmp_char;
			char[] charArray = new char[26];
			int charIndex = 0;

			for (int a = 0; a < cmp.length; a++) {
				cmp[a] = "";
			}

			//문자열을 각 문자끼리 묶어서 문자열 배열에 저장 
			for (int a = 0; a < Array.length(); a++) {
				boolean exist = false;
				//문자 배열을 순회하며 문자가 존재하는지 확인
				for (int b = 0; b < charArray.length; b++) {
					if (charArray[b] == Array.charAt(a)) {
						exist = true;
						break;
					}
				}
				if (exist == true)
					continue;

				cmp_char = Array.charAt(a);
				charArray[charIndex++] = cmp_char; //새로운 문자 저장.

				for (int b = a; b < Array.length(); b++) {
					if (cmp_char == Array.charAt(b))
						cmp[a] += cmp_char;
				}
			}

			boolean find = false;
			for (int a = 0; a < Array.length(); a++) {
				find = false;
				for (int j = 0; j + cmp[a].length() <= Array.length(); j++) {
					if (cmp[a].equals(Array.substring(j, j + cmp[a].length()))) {
						find = true;

						break;
					}
				}
				if (find == false) {
					break;
				}

			}
			if (find == true) {
				count++;
			}

			i++;
		}

		System.out.println(count);
	}

}

/*
문제
그룹 단어란 단어에 존재하는 모든 문자에 대해서, 각 문자가 연속해서 나타나는 경우만을 말한다. 예를 들면, ccazzzzbb는 c, a, z, b가 모두 연속해서 나타나고, kin도 k, i, n이 연속해서 나타나기 때문에 그룹 단어이지만, aabbbccb는 b가 떨어져서 나타나기 때문에 그룹 단어가 아니다.

단어 N개를 입력으로 받아 그룹 단어의 개수를 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 단어의 개수 N이 들어온다. N은 100보다 작거나 같은 자연수이다. 둘째 줄부터 N개의 줄에 단어가 들어온다. 단어는 알파벳 소문자로만 되어있고 중복되지 않으며, 길이는 최대 100이다.

출력
첫째 줄에 그룹 단어의 개수를 출력한다.
*/