package string;

import java.util.Scanner;

public class N1316 {

	public static void main(String[] argArray) {
		// TODO Auto-generated method Arraytub
		Scanner scan = new Scanner(System.in);
		// System.out.print("���ڿ� ������ �Է�: ");
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

			//���ڿ��� �� ���ڳ��� ��� ���ڿ� �迭�� ���� 
			for (int a = 0; a < Array.length(); a++) {
				boolean exist = false;
				//���� �迭�� ��ȸ�ϸ� ���ڰ� �����ϴ��� Ȯ��
				for (int b = 0; b < charArray.length; b++) {
					if (charArray[b] == Array.charAt(a)) {
						exist = true;
						break;
					}
				}
				if (exist == true)
					continue;

				cmp_char = Array.charAt(a);
				charArray[charIndex++] = cmp_char; //���ο� ���� ����.

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
����
�׷� �ܾ�� �ܾ �����ϴ� ��� ���ڿ� ���ؼ�, �� ���ڰ� �����ؼ� ��Ÿ���� ��츸�� ���Ѵ�. ���� ���, ccazzzzbb�� c, a, z, b�� ��� �����ؼ� ��Ÿ����, kin�� k, i, n�� �����ؼ� ��Ÿ���� ������ �׷� �ܾ�������, aabbbccb�� b�� �������� ��Ÿ���� ������ �׷� �ܾ �ƴϴ�.

�ܾ� N���� �Է����� �޾� �׷� �ܾ��� ������ ����ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� �ܾ��� ���� N�� ���´�. N�� 100���� �۰ų� ���� �ڿ����̴�. ��° �ٺ��� N���� �ٿ� �ܾ ���´�. �ܾ�� ���ĺ� �ҹ��ڷθ� �Ǿ��ְ� �ߺ����� ������, ���̴� �ִ� 100�̴�.

���
ù° �ٿ� �׷� �ܾ��� ������ ����Ѵ�.
*/