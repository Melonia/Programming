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
		
		s=s.toLowerCase(); //���� ������ �ľ��ϱ� ���� �ҹ��ڷ� ���� ��ȯ
		
		//A�� ������ a[0]���� ����. B�� ������ a[1]�� ����
		for(int i = 0; i < s.length(); i++) {
			a[s.charAt(i)-97]++;
		}
		
		/*
		 * for(int i = 0; i < 26; i++) {
			System.out.println(a[i]);
		   }
		*/
		
		//a�迭���� �ִ��� ã�´� �׸��� �� �ε����� �Է��Ѵ�.(�ε����� �� ���ĺ��̹Ƿ�)
		for(int i = 0; i < 26; i++) {
			if(max<a[i]) {
				max = a[i];
				index = i;
			}
		}
		
		//�ִ��� ���������� Ȯ���ϴ� �۾�
		for(int i = 0; i < 26; i++) {
			if(max == a[i]) count++;
		}
		
		if(count > 1) System.out.println("?");
		else System.out.println((char)(index+65)); //�ִ��� �ε����� �빮�ڷ� ��ȯ�Ͽ� ����Ѵ�.
		
	}

}

/*
����
���ĺ� ��ҹ��ڷ� �� �ܾ �־�����, �� �ܾ�� ���� ���� ���� ���ĺ��� �������� �˾Ƴ��� ���α׷��� �ۼ��Ͻÿ�. ��, �빮�ڿ� �ҹ��ڸ� �������� �ʴ´�.

�Է�
ù° �ٿ� ���ĺ� ��ҹ��ڷ� �̷���� �ܾ �־�����. �־����� �ܾ��� ���̴� 1,000,000�� ���� �ʴ´�.

���
ù° �ٿ� �� �ܾ�� ���� ���� ���� ���ĺ��� �빮�ڷ� ����Ѵ�. ��, ���� ���� ���� ���ĺ��� ���� �� �����ϴ� ��쿡�� ?�� ����Ѵ�.
*/