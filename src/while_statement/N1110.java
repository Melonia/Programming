package while_statement;

import java.util.Scanner;

public class N1110 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		
		int org_num,new_num,ten_num,one_num;
		int cycle = 0;
		org_num=scan.nextInt();
		
		if(org_num/10==0&&org_num!=0) {
			new_num=org_num*10+org_num;
			cycle++;
		}
		else {
			new_num=org_num;
		}
		
		//���ο� ���� ����� cycle�� ���Ѵ�. 
		//do ~ while�� ������ �� �ڸ� ���� ���ο� ���� 
		//���� ������ �̸� ������ ���� �ʱ� ���ؼ��̴�.
		do{
			ten_num=new_num/10;
			one_num=new_num%10;
			new_num=one_num*10+(ten_num+one_num)%10;
			cycle++;
		}while(new_num!=org_num);
	
		System.out.println(cycle);
	}
}
/*
����
0���� ũ�ų� ����, 99���� �۰ų� ���� ������ �־��� �� ������ ���� ������ �� �� �ִ�. ���� �־��� ���� 10���� �۴ٸ� �տ� 0�� �ٿ� �� �ڸ� ���� �����, �� �ڸ��� ���ڸ� ���Ѵ�. �� ����, �־��� ���� ���� ������ �ڸ� ���� �տ��� ���� ���� ���� ������ �ڸ� ���� �̾� ���̸� ���ο� ���� ���� �� �ִ�. ���� ���� ����.

26���� �����Ѵ�. 2+6 = 8�̴�. ���ο� ���� 68�̴�. 6+8 = 14�̴�. ���ο� ���� 84�̴�. 8+4 = 12�̴�. ���ο� ���� 42�̴�. 4+2 = 6�̴�. ���ο� ���� 26�̴�.

���� ���� 4������ ���� ���� ���ƿ� �� �ִ�. ���� 26�� ����Ŭ�� ���̴� 4�̴�.

N�� �־����� ��, N�� ����Ŭ�� ���̸� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� N�� �־�����. N�� 0���� ũ�ų� ����, 99���� �۰ų� ���� �����̴�.

���
ù° �ٿ� N�� ����Ŭ ���̸� ����Ѵ�.
*/