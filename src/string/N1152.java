package string;

import java.util.Scanner;

public class N1152 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String s = scan.nextLine();
		s = s.trim();
		if(s.isEmpty()) {
			System.out.println(0);
			return;
		}
		String[] s2 = s.split(" ");
		
		/*
		for(int i = 0;i<s2.length;i++)
		System.out.println(s2[i]);
		System.out.println(s2.length);
		*/
		
		for(int i = 0; i < s2.length; i++) {
			
			if(s2[i].isEmpty()) {
				
				
				for(int j = i; j < s2.length; j++) {
					if(!s2[j].isEmpty()) {
						s2[i] = s2[j];
						s2[j] = "";
						break;
					}		
				}
				//System.out.println("����Ծ���.");
			}

		}
		
		/*
		for(int i = 0;i<s2.length;i++)
			System.out.println(s2[i]);
		*/
		
		int length = 0;
		for(int i = 0; i < s2.length; i++) {
			if(s2[i].isEmpty()) {length = i; break;}
		}
		
		if(length == 0) {
			length = s2.length;
		}
		
		System.out.println(length);
	}

}

/*
����
���� ��ҹ��ڿ� ���⸸���� �̷���� ���ڿ��� �־�����. �� ���ڿ����� �� ���� �ܾ ������? �̸� ���ϴ� ���α׷��� �ۼ��Ͻÿ�. ��, �� �ܾ ���� �� �����ϸ� ������ Ƚ����ŭ ��� ����� �Ѵ�.

�Է�
ù �ٿ� ���� ��ҹ��ڿ� ����� �̷���� ���ڿ��� �־�����. �� ���ڿ��� ���̴� 1,000,000�� ���� �ʴ´�. �ܾ�� ���� �� ���� ���еǸ�, ������ �����ؼ� ������ ���� ����. ���� ���ڿ��� �հ� �ڿ��� ������ ���� ���� �ִ�.

���
ù° �ٿ� �ܾ��� ������ ����Ѵ�.
*/