package math2;

import java.util.Scanner;

public class N1085 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		int x,y,w,h;
		x = scanner.nextInt();
		y = scanner.nextInt();
		w = scanner.nextInt();
		h = scanner.nextInt();
		Min min = new Min();
		System.out.println(min.min(min.min(w-x, x),min.min(h-y, y)));
		
	}

}
class Min{
	int min(int x, int y) {
		return(x>y?y:x);
	}
}

/*
����
�Ѽ��� ���� (x, y)�� �ִ�. ���簢���� ���� �Ʒ� �������� (0, 0)�� �ְ�, ������ �� �������� (w, h)�� �ִ�. ���簢���� ��輱���� ���� �Ÿ��� �ּڰ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� x y w h�� �־�����. w�� h�� 1,000���� �۰ų� ���� �ڿ����̰�, x�� 1���� ũ�ų� ����, w-1���� �۰ų� ���� �ڿ����̰�, y�� 1���� ũ�ų� ����, h-1���� �۰ų� ���� �ڿ����̴�.

���
ù° �ٿ� ������ ������ ����Ѵ�.
*/